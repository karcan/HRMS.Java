package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.entity.JobTitle;

public interface JobTitleService {
	void save(JobTitle jobTitle);
	List<JobTitle> getAll();
	JobTitle getById(int id);
	JobTitle getByTitle(String title);
}
