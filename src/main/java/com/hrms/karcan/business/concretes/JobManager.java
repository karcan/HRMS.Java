package com.hrms.karcan.business.concretes;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hrms.karcan.business.abstracts.JobService;
import com.hrms.karcan.business.constants.Messages;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.ErrorDataResult;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.dataAccess.abstracts.JobRepository;
import com.hrms.karcan.entity.dtos.JobSummaryDto;
import com.hrms.karcan.entity.tables.Job;


@Service
public class JobManager implements JobService {

	private JobRepository jobRepository;
	
	@Autowired
	public JobManager(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobRepository.findAll());
	}

	@Override
	public DataResult<Job> save(@Valid @RequestBody Job job) {
		return new SuccessDataResult<>(Messages.JOB_SAVE_IS_SUCCESSFUL ,this.jobRepository.save(job));
	}
	
	@Override
	public DataResult<Job> setActive(int id, boolean status) {
		Job job = this.jobRepository.findById(id).orElse(null);
		
		if(job == null) {
			return new ErrorDataResult<>(ValidationMessages.JOB_IS_NOT_FOUND, null);
		}
		
		job.setActive(status);
		this.jobRepository.save(job);
		return new SuccessDataResult<>(Messages.JOB_SAVE_IS_SUCCESSFUL, job);
		
	}

	@Override
	public DataResult<List<JobSummaryDto>> getAllJobSummaryDto() {
		return new SuccessDataResult<List<JobSummaryDto>>(this.jobRepository.getAllJobSummaryDto());
	}
	
	@Override
	public DataResult<List<JobSummaryDto>> getAllJobSummaryDtoSorted(Sort.Direction direction, String property){
		Sort sort = Sort.by(direction, property);
		return new SuccessDataResult<List<JobSummaryDto>>(this.jobRepository.getAllJobSummaryDto(sort));
	}

	@Override
	public DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByCompanyName(String companyName) {
		return new SuccessDataResult<List<JobSummaryDto>>(this.jobRepository.getAllJobSummaryDtoByCompanyName(companyName));
	}

	@Override
	public DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByJobTitle(String jobTitle) {
		return new SuccessDataResult<List<JobSummaryDto>>(this.jobRepository.getAllJobSummaryDtoByJobTitle(jobTitle));
	}

	

}
