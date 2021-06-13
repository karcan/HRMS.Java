package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.ResumeQualificationService;
import com.hrms.karcan.core.utilities.mappers.ModelMapperUtils;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.dataAccess.abstracts.ResumeQualificationRepository;
import com.hrms.karcan.entity.dtos.resumes.ResumeQualificationDetailDto;
import com.hrms.karcan.entity.tables.ResumeQualification;

@Service
public class ResumeQualificationManager implements ResumeQualificationService {
	private ResumeQualificationRepository resumeQualificationRepository;

	@Autowired
	public ResumeQualificationManager(ResumeQualificationRepository resumeQualificationRepository) {
		this.resumeQualificationRepository = resumeQualificationRepository;
	}

	@Override
	public Result save(ResumeQualification resumeQualification) {
		this.resumeQualificationRepository.save(resumeQualification);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<ResumeQualification>> getAllByResumeId(int resumeId) {
		return new SuccessDataResult<List<ResumeQualification>>(this.resumeQualificationRepository.findAllByResumeId(resumeId));
	}

	@Override
	public DataResult<List<ResumeQualificationDetailDto>> getAllDetailDtoByResumeId(int resumeId) {
		return new SuccessDataResult<List<ResumeQualificationDetailDto>>(
				ModelMapperUtils.toList(
						this.getAllDetailDtoByResumeId(resumeId).getData(), 
						ResumeQualificationDetailDto.class
						)
				);
	}
	
	
}
