package com.hrms.karcan.business.concretes;

import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.EmployerVerificationService;
import com.hrms.karcan.business.abstracts.UserVerificationManager;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.dataAccess.abstracts.UserVerificationRepository;
import com.hrms.karcan.entity.tables.UserVerification;

@Service
public class EmployerVerificationManager extends UserVerificationManager implements EmployerVerificationService  {

	public EmployerVerificationManager(UserVerificationRepository userVerificationRepository) {
		super(userVerificationRepository);
	}

	@Override
	public DataResult<UserVerification> generate(int userId) {
		return super.generate(userId);
	}

	@Override
	public DataResult<UserVerification> verificate(String code) {
		return super.verificate(code);
	}

	
}
