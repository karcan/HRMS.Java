package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.CandidateService;
import com.hrms.karcan.business.constants.MailTemplates;
import com.hrms.karcan.business.constants.Messages;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.business.dependencyResolvers.factories.CandidateServiceFactory;
import com.hrms.karcan.core.utilities.business.CheckEngine;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.ErrorDataResult;
import com.hrms.karcan.core.utilities.result.ErrorResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.entity.tables.Candidate;
import com.hrms.karcan.entity.tables.UserVerification;

@Service
public class CandidateManager implements CandidateService {
	private CandidateServiceFactory factory;

	public CandidateManager(CandidateServiceFactory factory) {
		this.factory = factory;
	}

	@Override
	public DataResult<Candidate> save(Candidate candidate) {

		Result result = CheckEngine.run(checkCandidateIsNotRealPerson(candidate),
				checkIfEmailAlreadyExists(candidate.getEmail(), candidate.getId()),
				checkIfIdentityNumberAlreadyExists(candidate));

		if (!result.isSuccess()) {
			return new ErrorDataResult<Candidate>(result.getMessage(), null);
		}

		this.factory.candidateRepository().save(candidate);
		this.opVerificationCodeGenerateAndSendMail(candidate);

		return new SuccessDataResult<Candidate>(candidate);
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.factory.candidateRepository().findAll());
	}

	// Operations

	private void opVerificationCodeGenerateAndSendMail(Candidate candidate) {
		
		if (!this.factory.candidateRepository().existsById(candidate.getId())) {
			DataResult<UserVerification> userVerification = this.factory.candidateVerificationService().generate(candidate.getId());
			if (userVerification.isSuccess()) {
				this.factory.mailSendService().sendMail(
						candidate.getEmail(), 
						Messages.USER_VERIFICATION_SUBJECT,
						MailTemplates.CANDIDATE_VERIFICATION_BODY.replace("{code}",userVerification.getData().getCode())
						);
			}
		}
	}

	// Checks & Rules

	private Result checkCandidateIsNotRealPerson(Candidate candidate) {
		Result identityResult = this.factory.identityValidationService().checkIdentityNumber(
				candidate.getIdentityNumber(), 
				candidate.getFirstName(), 
				candidate.getLastName(),
				candidate.getBirthDate()
				);
		if (identityResult.isSuccess()) {
			return new ErrorResult(ValidationMessages.PERSON_ID_VERIFICATION);
		}
		return new SuccessResult();
	}

	private Result checkIfIdentityNumberAlreadyExists(Candidate candidate) {
		boolean result = this.factory.candidateRepository().existsByIdentityNumberAndIdNot(candidate.getIdentityNumber(), candidate.getId());
		if (result) {
			return new ErrorResult(ValidationMessages.USER_IDENTITY_NUMBER_IS_ALREADY_EXISTS);
		}
		return new SuccessResult();
	}

	private Result checkIfEmailAlreadyExists(String email, int userId) {
		return this.factory.userCheckService().checkIfEmailAlreadyExists(email, userId);
	}

}
