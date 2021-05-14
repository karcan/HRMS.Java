package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.karcan.entity.EmployerPhone;

public interface EmployerPhoneDao extends JpaRepository<EmployerPhone, Integer> {
	
}
