package com.hrms.karcan.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.karcan.entity.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {

	Optional<JobTitle> findByTitle(String title);
	
}
