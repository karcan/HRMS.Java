package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.entity.concretes.Employer;

public interface EmployerService {
	void save(Employer employer);
	List<Employer> getAll();
	Employer getById(int id);
	Employer getByPhoneNumber(String phoneNumber);
}
