package com.hrms.karcan.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.entity.tables.ResumeEducation;


public interface ResumeEducationService {
	DataResult<List<ResumeEducation>> getAllByResumeId(int id);
	DataResult<List<ResumeEducation>> getAllByResumeId(int id, Sort sort);
	DataResult<List<ResumeEducation>> getAllByResumeIdOrderBy(int id, Sort.Direction direction , String fieldName);
	DataResult<ResumeEducation> save(ResumeEducation resumeEducation);
}
