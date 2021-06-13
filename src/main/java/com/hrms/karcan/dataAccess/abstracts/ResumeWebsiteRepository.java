package com.hrms.karcan.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hrms.karcan.entity.tables.ResumeWebsite;

public interface ResumeWebsiteRepository extends JpaRepository<ResumeWebsite, Integer> {
	List<ResumeWebsite> findAllByResumeId(@Param("resumeId") int resumeId);
}
