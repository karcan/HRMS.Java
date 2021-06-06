package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.CandidateService;
import com.hrms.karcan.business.abstracts.IdentityValidationService;
import com.hrms.karcan.core.constants.ValidationMessages;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.ErrorResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.dataAccess.abstracts.CandidateRepository;
import com.hrms.karcan.entity.concretes.Candidate;

import net.bytebuddy.asm.Advice.This;

@Service
public class CandidateManager implements CandidateService {

	private CandidateRepository candidateRepository;
	private IdentityValidationService identityValidationService;
	
	@Autowired
	public CandidateManager(CandidateRepository candidateRepository, IdentityValidationService identityValidationService) {
		this.candidateRepository = candidateRepository;
		this.identityValidationService = identityValidationService;
	}
	
	
	@Override
	public Result save(Candidate candidate) {
		Result identityResult = this.identityValidationService.checkIdentityNumber(candidate.getIdentityNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate());
		if(!identityResult.isSuccess()){
			return new ErrorResult(ValidationMessages.personIdentityValidationError);
		}
		this.candidateRepository.save(candidate);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateRepository.findAll());
	}

}
