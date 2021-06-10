package com.hrms.karcan.business.abstracts;

import java.io.File;
import java.util.List;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.concretes.Resume;
import com.hrms.karcan.entity.dtos.resumes.ResumeDetailDto;
import com.hrms.karcan.entity.dtos.resumes.ResumeQualificationDetailDto;

public interface ResumeService {
	DataResult<List<ResumeDetailDto>> getAllResumeDetailDto();
	DataResult<ResumeDetailDto> getResumeDetailDtoById(int id);
	Result uploadImage(int id, File file);
	Result save(Resume resume);
	DataResult<Resume> getById(int id);
	DataResult<List<ResumeQualificationDetailDto>> getAllResumeQualificationDetailDto();
}
