package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.dtos.resumes.ResumeWebsiteDetailDto;
import com.hrms.karcan.entity.tables.ResumeWebsite;

public interface ResumeWebsiteService {
	Result save(ResumeWebsite resumeWebsite);
	DataResult<List<ResumeWebsite>> getAllByResumeId(int resumeId);
	DataResult<List<ResumeWebsiteDetailDto>> getAllDetailDtoByResumeId(int resumeId);
}
