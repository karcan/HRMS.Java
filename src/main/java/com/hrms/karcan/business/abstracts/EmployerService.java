package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.entity.Employer;

public interface EmployerService {
	List<Employer> getAll();
	Employer getByPhoneNumber(String phoneNumber);
}
