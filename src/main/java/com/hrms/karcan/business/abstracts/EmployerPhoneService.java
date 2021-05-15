package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.entity.concretes.EmployerPhone;

public interface EmployerPhoneService {
	List<EmployerPhone> getAll();
	List<EmployerPhone> getByUserId(int userId);
}
