package com.hrms.karcan.business.dependencyResolvers.factories;

import com.hrms.karcan.core.dataAccess.UserRepository;
import com.hrms.karcan.dataAccess.abstracts.EmployeeRepository;
import com.hrms.karcan.dataAccess.abstracts.EmployerRepository;
import com.hrms.karcan.dataAccess.abstracts.UserConfirmRepository;
import com.hrms.karcan.dataAccess.abstracts.UserVerificationRepository;

public interface EmployerConfirmServiceFactory {
	UserConfirmRepository userConfirmRepository();
	UserVerificationRepository userVerificationRepository();
	UserRepository userRepository();
	EmployeeRepository employeeRepository();
	EmployerRepository employerRepository();
}
