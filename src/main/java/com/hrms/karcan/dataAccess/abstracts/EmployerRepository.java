package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.karcan.entity.concretes.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {

}
