package com.hrms.karcan.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hrms.karcan.entity.tables.ResumeQualification;

public interface ResumeQualificationRepository extends JpaRepository<ResumeQualification, Integer> {
	List<ResumeQualification> findAllByResumeId(@Param("resumeId") int resumeId);
}
