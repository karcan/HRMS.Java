package com.hrms.karcan.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.concretes.Job;
import com.hrms.karcan.entity.dtos.JobSummaryDto;

public interface JobService {
	DataResult<List<Job>> getAll();
	DataResult<List<JobSummaryDto>> getAllJobSummaryDto();
	DataResult<List<JobSummaryDto>> getAllJobSummaryDtoSorted(Sort.Direction direction, String property);
	DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByCompanyName(String companyName);
	DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByJobTitle(String jobTitle);
	Result save(Job job);
	Result setActive(int id, boolean status);
}
