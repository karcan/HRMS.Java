package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.dtos.resumes.ResumeLanguageDetailDto;
import com.hrms.karcan.entity.tables.ResumeLanguage;

public interface ResumeLanguageService {
	Result save(ResumeLanguage resumeLanguage);
	DataResult<List<ResumeLanguage>> getAllByResumeId(int resumeId);
	DataResult<List<ResumeLanguageDetailDto>> getAllDetailDtoByResumeId(int resumeId);
	
}
