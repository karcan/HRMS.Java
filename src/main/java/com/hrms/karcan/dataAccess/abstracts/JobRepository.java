package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.karcan.entity.concretes.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {
	
}
