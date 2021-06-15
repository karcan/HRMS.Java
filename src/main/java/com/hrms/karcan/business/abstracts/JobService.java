package com.hrms.karcan.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.entity.dtos.JobSummaryDto;
import com.hrms.karcan.entity.tables.Job;

public interface JobService {
	DataResult<List<Job>> getAll();
	DataResult<List<JobSummaryDto>> getAllJobSummaryDto();
	DataResult<List<JobSummaryDto>> getAllJobSummaryDtoSorted(Sort.Direction direction, String property);
	DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByCompanyName(String companyName);
	DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByJobTitle(String jobTitle);
	DataResult<Job> save(Job job);
	DataResult<Job> setActive(int id, boolean status);
}
