package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.entity.dtos.resumes.ResumeDetailDto;
import com.hrms.karcan.entity.dtos.resumes.ResumeQualificationDetailDto;

public interface ResumeService {
	DataResult<List<ResumeDetailDto>> getAllResumeDetailDto();
	DataResult<ResumeDetailDto> getResumeDetailDtoById(int id);
	
	DataResult<List<ResumeQualificationDetailDto>> getAllResumeQualificationDetailDto();
}
