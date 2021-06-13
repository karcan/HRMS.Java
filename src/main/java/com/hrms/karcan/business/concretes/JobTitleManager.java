package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.JobTitleService;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.core.utilities.business.CheckEngine;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.ErrorResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.dataAccess.abstracts.JobTitleRepository;
import com.hrms.karcan.entity.tables.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {
	
	private JobTitleRepository jobTitleRepository;
	
	@Autowired
	public JobTitleManager(JobTitleRepository jobTitleRepository) {
		this.jobTitleRepository = jobTitleRepository;
	}

	
	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleRepository.findAll());
	}

	@Override
	public Result save(JobTitle jobTitle) {
		
		Result result = CheckEngine.run(
				checkIfExistsJobTitle(jobTitle)
				);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		this.jobTitleRepository.save(jobTitle);
		
		return new SuccessResult();
	}
	
	private Result checkIfExistsJobTitle(JobTitle jobTitle) {		
		boolean result = this.jobTitleRepository.existsByTitle(jobTitle.getTitle());
		
		if(result) {
			return new ErrorResult(ValidationMessages.JOB_TITLE_ALREADY_EXISTS);
		}	
		return new SuccessResult(); 
	}
}
