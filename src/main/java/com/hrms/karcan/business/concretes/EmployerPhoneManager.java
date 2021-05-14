package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.EmployerPhoneService;
import com.hrms.karcan.dataAccess.abstracts.EmployerPhoneDao;
import com.hrms.karcan.entity.EmployerPhone;

@Service
public class EmployerPhoneManager implements EmployerPhoneService{

	private EmployerPhoneDao employerPhoneDao;
	
	public EmployerPhoneManager(EmployerPhoneDao employerPhoneDao) {
		super();
		this.employerPhoneDao = employerPhoneDao;
	}


	@Override
	public List<EmployerPhone> getAll() {
		return this.employerPhoneDao.findAll();
	}
	
}
