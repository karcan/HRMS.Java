package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.CandidateService;
import com.hrms.karcan.business.abstracts.CandidateVerificationService;
import com.hrms.karcan.business.abstracts.IdentityValidationService;
import com.hrms.karcan.business.abstracts.MailSendService;
import com.hrms.karcan.business.abstracts.UserCheckService;
import com.hrms.karcan.business.constants.Messages;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.core.utilities.business.CheckEngine;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.ErrorDataResult;
import com.hrms.karcan.core.utilities.result.ErrorResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.dataAccess.abstracts.CandidateRepository;
import com.hrms.karcan.entity.tables.Candidate;
import com.hrms.karcan.entity.tables.UserVerification;


@Service
public class CandidateManager implements CandidateService {

	private CandidateRepository candidateRepository;
	private IdentityValidationService identityValidationService;
	private CandidateVerificationService candidateVerificationService;
	private UserCheckService userCheckService;
	private MailSendService mailSendService;
	
	@Autowired
	public CandidateManager(CandidateRepository candidateRepository, IdentityValidationService identityValidationService, CandidateVerificationService candidateVerificationService, UserCheckService userCheckService, MailSendService mailSendService) {
		this.candidateRepository = candidateRepository;
		this.identityValidationService = identityValidationService;
		this.candidateVerificationService = candidateVerificationService;
		this.userCheckService = userCheckService;
		this.mailSendService = mailSendService;
	}
	
	
	@Override
	public DataResult<Candidate> save(Candidate candidate) {
		
		Result result = CheckEngine.run(
				checkCandidateIsNotRealPerson(candidate),
				this.userCheckService.checkIfEmailAlreadyExists(candidate.getEmail(), candidate.getId()),
				checkIfIdentityNumberAlreadyExists(candidate)
				);
		
		if(!result.isSuccess()) {
			return new ErrorDataResult<Candidate>(result.getMessage(), null);
		}
		
		this.candidateRepository.save(candidate);
		
		
		DataResult<UserVerification> userVerification = this.candidateVerificationService.generate(candidate.getId());
		if(userVerification.isSuccess()) {
			this.mailSendService.sendMail(candidate.getEmail(), Messages.USER_VERIFICATION_SUBJECT, userVerification.getData().getCode());
		}
		
		return new SuccessDataResult<Candidate>(candidate);
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateRepository.findAll());
	}

	
	private Result checkCandidateIsNotRealPerson(Candidate candidate)
	{
		Result identityResult = this.identityValidationService.checkIdentityNumber(
				candidate.getIdentityNumber(), 
				candidate.getFirstName(), 
				candidate.getLastName(), 
				candidate.getBirthDate()
				);
		
		if(identityResult.isSuccess()){
			return new ErrorResult(ValidationMessages.PERSON_ID_VERIFICATION);
		}
		
		return new SuccessResult();
	}
	
	private Result checkIfIdentityNumberAlreadyExists(Candidate candidate) {
		boolean result = this.candidateRepository.existsByIdentityNumberAndIdNot(candidate.getIdentityNumber(), candidate.getId());
		
		if(result) {
			return new ErrorResult(ValidationMessages.USER_IDENTITY_NUMBER_IS_ALREADY_EXISTS);
		}
		
		return new SuccessResult();
	}

}
