package com.hrms.karcan.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.UserCheckService;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.core.dataAccess.UserRepository;
import com.hrms.karcan.core.utilities.result.ErrorResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessResult;

@Service
public class UserCheckManager implements UserCheckService {

	private UserRepository userRepository;

	@Autowired
	public UserCheckManager(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public Result checkIfEmailAlreadyExists(String email, int id) {
		boolean result = this.userRepository.existsByEmailAndIdNot(email, id);
		
		if(result) {
			return new ErrorResult(ValidationMessages.USER_EMAIL_IS_ALREADY_EXISTS);
		}
		
		return new SuccessResult();
	}

}
