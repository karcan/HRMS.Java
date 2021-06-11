package com.hrms.karcan.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hrms.karcan.entity.concretes.ResumeLanguage;

public interface ResumeLanguageRepository extends JpaRepository<ResumeLanguage, Integer> {
	List<ResumeLanguage> findAllByResumeId(@Param("resumeId") int resumeId);
}
