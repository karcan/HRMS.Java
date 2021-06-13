package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.ResumeLanguageService;
import com.hrms.karcan.core.utilities.mappers.ModelMapperUtils;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.dataAccess.abstracts.ResumeLanguageRepository;
import com.hrms.karcan.entity.dtos.resumes.ResumeLanguageDetailDto;
import com.hrms.karcan.entity.tables.ResumeLanguage;

@Service
public class ResumeLanguageManager implements ResumeLanguageService{
	private ResumeLanguageRepository resumeLanguageRepository;

	@Autowired
	public ResumeLanguageManager(ResumeLanguageRepository resumeLanguageRepository) {
		this.resumeLanguageRepository = resumeLanguageRepository;
	}

	@Override
	public Result save(ResumeLanguage resumeLanguage) {
		this.resumeLanguageRepository.save(resumeLanguage);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<ResumeLanguage>> getAllByResumeId(int resumeId) {
		return new SuccessDataResult<List<ResumeLanguage>>(this.resumeLanguageRepository.findAllByResumeId(resumeId));
	}
	@Override
	public DataResult<List<ResumeLanguageDetailDto>> getAllDetailDtoByResumeId(int resumeId) {
		return new SuccessDataResult<List<ResumeLanguageDetailDto>>(ModelMapperUtils.toList(this.getAllByResumeId(resumeId).getData(), ResumeLanguageDetailDto.class));
	}
	
	
}
