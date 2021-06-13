package com.hrms.karcan.business.concretes;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.ResumeService;
import com.hrms.karcan.business.abstracts.UploaderService;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.core.utilities.business.CheckEngine;
import com.hrms.karcan.core.utilities.mappers.ModelMapperUtils;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.ErrorResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.dataAccess.abstracts.ResumeRepository;
import com.hrms.karcan.entity.dtos.resumes.ResumeDetailDto;
import com.hrms.karcan.entity.dtos.resumes.ResumeSummaryDto;
import com.hrms.karcan.entity.tables.Resume;


@Service
public class ResumeManager implements ResumeService {

	private ResumeRepository resumeRepository;
	private UploaderService uploaderService;
	
	@Autowired
	public ResumeManager(ResumeRepository resumeRepository, UploaderService uploaderService) {
		this.resumeRepository = resumeRepository;
		this.uploaderService = uploaderService;
	}

	public DataResult<List<ResumeSummaryDto>> getAllSummaryDto() {
		return new SuccessDataResult<List<ResumeSummaryDto>>(ModelMapperUtils.toList(
				this.resumeRepository.findAll(),
				ResumeSummaryDto.class)
				);
	}
	
	@Override
	public DataResult<List<ResumeDetailDto>> getDetailDtoById(int id) {
		return new SuccessDataResult<List<ResumeDetailDto>>(ModelMapperUtils.toList(
				this.resumeRepository.findAll(),
				ResumeDetailDto.class)
				);
	}
	
	@Override
	public Result save(Resume resume) {
		this.resumeRepository.save(resume);
		return new SuccessResult();
	}
	
	@Override
	public Result setImage(int id, File file) {	
		
		Result result = CheckEngine.run(
				CheckResumeIfNotExists(id)
				);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		Result imageResult = this.uploaderService.imageUpload(file);
		Resume resume = getById(id).getData();
		resume.setProfilePictureUrl(imageResult.getMessage());
		this.save(resume);
		
		return imageResult;
	}
	
	@Override
	public DataResult<Resume> getById(int id) {
		return new SuccessDataResult<Resume>(this.resumeRepository.findById(id).orElse(null));
	}
	
	private Result CheckResumeIfNotExists(int id) {
		boolean result = this.resumeRepository.existsById(id);
		if(!result) {
			return new ErrorResult(ValidationMessages.RESUME_IS_NOT_EXISTS);
		}
		
		return new SuccessResult();
	}

}
