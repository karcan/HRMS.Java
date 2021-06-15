package com.hrms.karcan.business.abstracts;

import java.io.File;
import java.util.List;

import org.cloudinary.json.JSONObject;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.entity.dtos.resumes.ResumeDetailDto;
import com.hrms.karcan.entity.dtos.resumes.ResumeSummaryDto;
import com.hrms.karcan.entity.tables.Resume;

public interface ResumeService {
	DataResult<List<ResumeSummaryDto>> getAllSummaryDto();
	DataResult<List<ResumeDetailDto>> getDetailDtoById(int id);
	DataResult<Resume> setImage(int id, File file);
	DataResult<Resume> save(Resume resume);
	DataResult<Resume> getById(int id);
}
