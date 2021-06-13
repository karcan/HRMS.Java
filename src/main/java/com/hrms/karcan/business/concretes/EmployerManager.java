package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.EmployerService;
import com.hrms.karcan.business.constants.Messages;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.business.dependencyResolvers.factories.EmployerServiceFactory;
import com.hrms.karcan.core.utilities.business.CheckEngine;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.ErrorResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.entity.tables.Employer;
import com.hrms.karcan.entity.tables.UserVerification;

@Service
public class EmployerManager implements EmployerService {
	private EmployerServiceFactory factory;
	
	@Autowired
	public EmployerManager(EmployerServiceFactory employerServiceFactory) {
		this.factory = employerServiceFactory;
	}

	@Override
	public List<Employer> getAll() {
		return this.factory.employerRepository().findAll();
	}
	
	@Override
	public Result save(Employer employer) {
		
		Result result = CheckEngine.run(
				this.factory.userCheckService().checkIfEmailAlreadyExists(employer.getEmail(), employer.getId()),
				checkIfNotBeTheSameEmailAndWebsite(employer)
				);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		this.factory.employerRepository().save(employer);
		DataResult<UserVerification> userVerification = this.factory.employerVerificationService().generate(employer.getId());
		if(userVerification.isSuccess()) {
			this.factory.mailSendService().sendMail(employer.getEmail(), Messages.USER_VERIFICATION_SUBJECT, userVerification.getData().getCode());
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
