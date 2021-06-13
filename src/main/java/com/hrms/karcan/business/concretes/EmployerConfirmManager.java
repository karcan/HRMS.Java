package com.hrms.karcan.business.concretes;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.EmployerConfirmService;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.business.dependencyResolvers.factories.EmployerConfirmServiceFactory;
import com.hrms.karcan.core.entity.User;
import com.hrms.karcan.core.utilities.business.CheckEngine;
import com.hrms.karcan.core.utilities.result.ErrorResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.entity.tables.UserConfirm;

@Service
public class EmployerConfirmManager implements EmployerConfirmService {

	private EmployerConfirmServiceFactory factory;
	
	@Autowired
	public EmployerConfirmManager(EmployerConfirmServiceFactory factory) {
		this.factory = factory;
	}


	@Override
	public Result confirm(int userId, int confirmerUserId) {
		Result result = CheckEngine.run(
				this.checkIfConfirmerIsNotEmployee(confirmerUserId),
				this.checkIfUserIsNotEmployer(userId),
				this.checkIfUserIsNotVerificated(userId),
				this.checkIfUserAlreadyConfirmed(userId)
				);
		
		if(!result.isSuccess()) {
			return result;
		}

		User user = this.factory.userRepository().getById(userId);
		user.setActive(true);
		this.factory.userRepository().save(user);
		
		
		UserConfirm userConfirm = new UserConfirm();
		userConfirm.setUserId(userId);
		userConfirm.setConfirmedUserId(confirmerUserId);
		userConfirm.setConfirmedDate(Instant.now());
		userConfirm.setConfirmed(true);
		this.factory.userConfirmRepository().save(userConfirm);
		
		return new SuccessResult();
	}
	
	
	private Result checkIfUserIsNotVerificated(int userId) {
		boolean result = this.factory.userVerificationRepository().userIsVerificated(userId);
		if(!result) {
			return new ErrorResult(ValidationMessages.USER_IS_MUST_BE_VERIFIED_FIRST);
		}
		
		return new SuccessResult();
	}
	
	private Result checkIfUserAlreadyConfirmed(int userId) {
		boolean result = this.factory.userConfirmRepository().isConfirmed(userId);
		if(result) {
			return new ErrorResult(ValidationMessages.USER_IS_ALREADY_CONFIRMED);
		}
		
		return new SuccessResult();
	}
	
	private Result checkIfConfirmerIsNotEmployee(int confirmerUserId) {
		boolean result = this.factory.employeeRepository().existsById(confirmerUserId);
		if(!result) {
			return new ErrorResult(ValidationMessages.CONFIRMER_IS_NOT_EMPLOYEE);
		}
		
		return new SuccessResult();
	}
	
	private Result checkIfUserIsNotEmployer(int userId) {
		boolean result = this.factory.employerRepository().existsById(userId);
		if(!result) {
			return new ErrorResult(ValidationMessages.USER_IS_NOT_EMPLOYER);
		}
		
		return new SuccessResult();
	}


}
