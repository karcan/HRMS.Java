package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.concretes.ResumeQualification;
import com.hrms.karcan.entity.dtos.resumes.ResumeQualificationDetailDto;

public interface ResumeQualificationService  {
	Result save(ResumeQualification resumeQualification);
	DataResult<List<ResumeQualification>> getAllByResumeId(int resumeId);
	DataResult<List<ResumeQualificationDetailDto>> getAllDetailDtoByResumeId(int resumeId);
}
