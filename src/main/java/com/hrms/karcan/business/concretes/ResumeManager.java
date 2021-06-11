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
import com.hrms.karcan.dataAccess.abstracts.ResumeQualificationRepository;
import com.hrms.karcan.dataAccess.abstracts.ResumeRepository;
import com.hrms.karcan.entity.concretes.Resume;
import com.hrms.karcan.entity.dtos.resumes.ResumeDetailDto;
import com.hrms.karcan.entity.dtos.resumes.ResumeQualificationDetailDto;


@Service
public class ResumeManager implements ResumeService {

	private ResumeRepository resumeRepository;
	private ResumeQualificationRepository resumeQualificationRepository;
	private UploaderService uploaderService;
	
	@Autowired
	public ResumeManager(ResumeRepository resumeRepository, ResumeQualificationRepository resumeQualificationRepository, UploaderService uploaderService) {
		this.resumeRepository = resumeRepository;
		this.resumeQualificationRepository = resumeQualificationRepository;
		this.uploaderService = uploaderService;
	}

	@Override
	public DataResult<List<ResumeDetailDto>> getAllResumeDetailDto() {
		return new SuccessDataResult<List<ResumeDetailDto>>(ModelMapperUtils.toList(
				this.resumeRepository.findAll(),
				ResumeDetailDto.class)
				);
	}

	@Override
	public DataResult<ResumeDetailDto> getResumeDetailDtoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<ResumeQualificationDetailDto>> getAllResumeQualificationDetailDto() {
		return new SuccessDataResult<List<ResumeQualificationDetailDto>>(ModelMapperUtils.toList(
				this.resumeQualificationRepository.findAll(), 
				ResumeQualificationDetailDto.class)
				);
	}
	
	@Override
	public DataResult<Resume> getById(int id) {
		return new SuccessDataResult<Resume>(this.resumeRepository.findById(id).orElse(null));
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
	
	private Result CheckResumeIfNotExists(int id) {
		boolean result = this.resumeRepository.existsById(id);
		if(!result) {
			return new ErrorResult(ValidationMessages.RESUME_IS_NOT_EXISTS);
		}
		
		return new SuccessResult();
	}

	@Override
	public Result save(Resume resume) {
		this.resumeRepository.save(resume);
		return new SuccessResult();
	}

	

}
