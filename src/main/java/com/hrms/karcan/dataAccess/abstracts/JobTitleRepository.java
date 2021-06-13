package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hrms.karcan.entity.tables.JobTitle;

public interface JobTitleRepository extends JpaRepository<JobTitle, Integer>{
	boolean existsByTitle(@Param("title") String title);
}
