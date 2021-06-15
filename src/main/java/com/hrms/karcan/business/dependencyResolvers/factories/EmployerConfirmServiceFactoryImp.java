package com.hrms.karcan.business.dependencyResolvers.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.core.dataAccess.abstracts.UserRepository;
import com.hrms.karcan.dataAccess.abstracts.EmployeeRepository;
import com.hrms.karcan.dataAccess.abstracts.EmployerRepository;
import com.hrms.karcan.dataAccess.abstracts.UserConfirmRepository;
import com.hrms.karcan.dataAccess.abstracts.UserVerificationRepository;

@Service
public class EmployerConfirmServiceFactoryImp implements EmployerConfirmServiceFactory{
	private UserConfirmRepository userConfirmRepository;
	private UserVerificationRepository userVerificationRepository;
	private UserRepository userRepository;
	private EmployeeRepository employeeRepository;
	private EmployerRepository employerRepository;
	
	@Autowired
	public EmployerConfirmServiceFactoryImp(UserConfirmRepository userConfirmRepository,UserVerificationRepository userVerificationRepository, UserRepository userRepository, EmployeeRepository employeeRepository, EmployerRepository employerRepository) {
		this.userConfirmRepository = userConfirmRepository;
		this.userVerificationRepository = userVerificationRepository;
		this.userRepository = userRepository;
		this.employeeRepository = employeeRepository;
		this.employerRepository = employerRepository;
	}

	@Override
	public UserConfirmRepository userConfirmRepository() {
		return userConfirmRepository;
	}

	@Override
	public UserVerificationRepository userVerificationRepository() {
		return userVerificationRepository;
	}

	@Override
	public UserRepository userRepository() {
		return userRepository;
	}

	@Override
	public EmployeeRepository employeeRepository() {
		return employeeRepository;
	}

	@Override
	public EmployerRepository employerRepository() {
		return employerRepository;
	}
	
	
}
