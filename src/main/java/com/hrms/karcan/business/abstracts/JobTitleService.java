package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.tables.JobTitle;

public interface JobTitleService {
	DataResult<List<JobTitle>> getAll();
	Result save(JobTitle jobTitle);
}
