package com.hrms.karcan.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hrms.karcan.entity.tables.ResumeEducation;


public interface ResumeEducationRepository extends JpaRepository<ResumeEducation, Integer> {
	List<ResumeEducation> findAllByResumeId(@Param("id") int id);
	List<ResumeEducation> findAllByResumeId(@Param("id") int id, Sort sort);

}
