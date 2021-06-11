package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.ResumeWebsiteService;
import com.hrms.karcan.core.utilities.mappers.ModelMapperUtils;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.dataAccess.abstracts.ResumeWebsiteRepository;
import com.hrms.karcan.entity.concretes.ResumeWebsite;
import com.hrms.karcan.entity.dtos.resumes.ResumeWebsiteDetailDto;

@Service
public class ResumeWebsiteManager implements ResumeWebsiteService {
	private ResumeWebsiteRepository resumeWebsiteRepository;
	
	@Autowired
	public ResumeWebsiteManager(ResumeWebsiteRepository resumeWebsiteRepository) {
		this.resumeWebsiteRepository = resumeWebsiteRepository;
	}

	@Override
	public Result save(ResumeWebsite resumeWebsite) {
		this.resumeWebsiteRepository.save(resumeWebsite);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<ResumeWebsite>> getAllByResumeId(int resumeId) {
		return new SuccessDataResult<List<ResumeWebsite>>(this.resumeWebsiteRepository.findAllByResumeId(resumeId));
	}

	@Override
	public DataResult<List<ResumeWebsiteDetailDto>> getAllDetailDtoByResumeId(int resumeId) {
		return new SuccessDataResult<List<ResumeWebsiteDetailDto>>(
				ModelMapperUtils.toList(
						this.getAllByResumeId(resumeId).getData(), 
						ResumeWebsiteDetailDto.class
						)
				);
	}

}
