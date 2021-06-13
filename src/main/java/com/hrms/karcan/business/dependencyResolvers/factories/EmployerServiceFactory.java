package com.hrms.karcan.business.dependencyResolvers.factories;

import com.hrms.karcan.business.abstracts.EmployerVerificationService;
import com.hrms.karcan.business.abstracts.MailSendService;
import com.hrms.karcan.business.abstracts.UserCheckService;
import com.hrms.karcan.dataAccess.abstracts.EmployerRepository;

public interface EmployerServiceFactory {
	EmployerRepository employerRepository();
	UserCheckService userCheckService();
	MailSendService mailSendService();
	EmployerVerificationService employerVerificationService();
}
