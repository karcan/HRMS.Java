package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.EmployerService;
import com.hrms.karcan.business.abstracts.EmployerVerificationService;
import com.hrms.karcan.business.abstracts.MailSendService;
import com.hrms.karcan.business.abstracts.UserCheckService;
import com.hrms.karcan.business.constants.Messages;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.core.utilities.business.CheckEngine;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.ErrorResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.dataAccess.abstracts.EmployerRepository;
import com.hrms.karcan.entity.tables.Employer;
import com.hrms.karcan.entity.tables.UserVerification;

@Service
public class EmployerManager implements EmployerService {

	private EmployerRepository employerRepository;
	private UserCheckService userCheckService;
	private MailSendService mailSendService;
	private EmployerVerificationService employerVerificationService;

	@Autowired
	public EmployerManager(EmployerRepository employerRepository, UserCheckService userCheckService, MailSendService mailSendService, EmployerVerificationService employerVerificationService) {
		this.employerRepository = employerRepository;
		this.userCheckService = userCheckService;
		this.mailSendService = mailSendService;
		this.employerVerificationService = employerVerificationService;
	}

	@Override
	public List<Employer> getAll() {
		return this.employerRepository.findAll();
	}
	
	@Override
	public Result save(Employer employer) {
		
		Result result = CheckEngine.run(
				this.userCheckService.checkIfEmailAlreadyExists(employer.getEmail(), employer.getId()),
				checkIfNotBeTheSameEmailAndWebsite(employer)
				);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		employerRepository.save(employer);
		DataResult<UserVerification> userVerification = this.employerVerificationService.generate(employer.getId());
		if(userVerification.isSuccess()) {
			this.mailSendService.sendMail(employer.getEmail(), Messages.USER_VERIFICATION_SUBJECT, userVerification.getData().getCode());
		}
		
		return new SuccessResult();
	}
	
	private Result checkIfNotBeTheSameEmailAndWebsite(Employer employer) 
	{
		int atIndex = employer.getEmail().indexOf("@");
		String mailDomain = employer.getEmail().substring(atIndex + 1);
		
		if(!employer.getWebsite().contains(mailDomain)) {
			return new ErrorResult(ValidationMessages.EMAIL_AND_WEBSITE_MUST_BE_THE_SAME);
		}
		
		return new SuccessResult();
	}
}
