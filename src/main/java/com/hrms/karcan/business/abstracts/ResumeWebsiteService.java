package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.concretes.ResumeWebsite;
import com.hrms.karcan.entity.dtos.resumes.ResumeWebsiteDetailDto;

public interface ResumeWebsiteService {
	Result save(ResumeWebsite resumeWebsite);
	DataResult<List<ResumeWebsite>> getAllByResumeId(int resumeId);
	DataResult<List<ResumeWebsiteDetailDto>> getAllDetailDtoByResumeId(int resumeId);
}