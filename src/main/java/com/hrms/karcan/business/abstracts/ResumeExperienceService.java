package com.hrms.karcan.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.tables.ResumeExperience;

public interface ResumeExperienceService {
	DataResult<List<ResumeExperience>> getAllByResumeId(int id);
	DataResult<List<ResumeExperience>> getAllByResumeId(int id, Sort sort);
	DataResult<List<ResumeExperience>> getAllByResumeIdOrderBy(int id, Sort.Direction direction , String fieldName);
	Result save(ResumeExperience resumeExperience);
}
