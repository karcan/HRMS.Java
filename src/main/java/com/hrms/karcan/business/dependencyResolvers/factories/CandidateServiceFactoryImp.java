package com.hrms.karcan.business.dependencyResolvers.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.CandidateVerificationService;
import com.hrms.karcan.business.abstracts.IdentityValidationService;
import com.hrms.karcan.business.abstracts.MailSendService;
import com.hrms.karcan.business.abstracts.UserCheckService;
import com.hrms.karcan.dataAccess.abstracts.CandidateRepository;

@Service
public class CandidateServiceFactoryImp implements CandidateServiceFactory {

	private CandidateRepository candidateRepository;
	private IdentityValidationService identityValidationService;
	private CandidateVerificationService candidateVerificationService;
	private UserCheckService userCheckService;
	private MailSendService mailSendService;
	
	@Autowired
	public CandidateServiceFactoryImp(CandidateRepository candidateRepository, IdentityValidationService identityValidationService, CandidateVerificationService candidateVerificationService, UserCheckService userCheckService, MailSendService mailSendService) {
		this.candidateRepository = candidateRepository;
		this.identityValidationService = identityValidationService;
		this.candidateVerificationService = candidateVerificationService;
		this.userCheckService = userCheckService;
		this.mailSendService = mailSendService;
	}
	
	@Override
	public CandidateRepository candidateRepository() {
		return candidateRepository;
	}

	@Override
	public IdentityValidationService identityValidationService() {
		return identityValidationService;
	}

	@Override
	public CandidateVerificationService candidateVerificationService() {
		return candidateVerificationService;
	}

	@Override
	public UserCheckService userCheckService() {
		return userCheckService;
	}

	@Override
	public MailSendService mailSendService() {
		return mailSendService;
	}

}
