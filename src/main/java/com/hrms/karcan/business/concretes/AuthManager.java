package com.hrms.karcan.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.AuthService;
import com.hrms.karcan.business.abstracts.CandidateService;
import com.hrms.karcan.business.abstracts.IdentityValidationService;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.concretes.Candidate;

@Service
public class AuthManager implements AuthService {
	
	private IdentityValidationService identityValidationService;
	private CandidateService candidateService;

	@Autowired
	public AuthManager(IdentityValidationService identityValidationService, CandidateService candidateService) {
		super();
		this.identityValidationService = identityValidationService;
		this.candidateService = candidateService;
	}

	@Override
	public Result login(String emailAdress, String password) {
		Candidate candidate = this.candidateService.getByEmailAddress(emailAdress);
		return this.identityValidationService.CheckIfRealPerson(candidate.getIdentificationNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate());
	}

}
