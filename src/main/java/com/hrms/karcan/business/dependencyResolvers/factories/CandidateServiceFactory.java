package com.hrms.karcan.business.dependencyResolvers.factories;

import com.hrms.karcan.business.abstracts.CandidateVerificationService;
import com.hrms.karcan.business.abstracts.IdentityValidationService;
import com.hrms.karcan.business.abstracts.MailSendService;
import com.hrms.karcan.business.abstracts.UserCheckService;
import com.hrms.karcan.dataAccess.abstracts.CandidateRepository;

public interface CandidateServiceFactory {
	CandidateRepository candidateRepository();
	IdentityValidationService identityValidationService();
	CandidateVerificationService candidateVerificationService();
	UserCheckService userCheckService();
	MailSendService mailSendService();
}
