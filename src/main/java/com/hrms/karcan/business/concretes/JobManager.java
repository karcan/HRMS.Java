package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.JobService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.dataAccess.abstracts.JobRepository;
import com.hrms.karcan.entity.concretes.Job;

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
	public Result save(Job job) {
		this.jobRepository.save(job);
		
		return new SuccessResult();
	}

}
