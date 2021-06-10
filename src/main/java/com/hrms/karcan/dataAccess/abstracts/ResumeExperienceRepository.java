package com.hrms.karcan.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hrms.karcan.entity.concretes.ResumeExperience;

public interface ResumeExperienceRepository extends JpaRepository<ResumeExperience, Integer> {
	List<ResumeExperience> findAllByResumeId(@Param("resumeId") int resumeId);
	List<ResumeExperience> findAllByResumeId(@Param("resumeId") int resumeId, Sort sort);
}
