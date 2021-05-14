package com.hrms.karcan.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.JobTitleService;
import com.hrms.karcan.dataAccess.abstracts.JobTitleDao;
import com.hrms.karcan.entity.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;
	
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}


	@Override
	public List<JobTitle> getAll() {
		return this.jobTitleDao.findAll();
	}


	@Override
	public JobTitle getById(int id) {
		return this.jobTitleDao.findById(id).orElse(null);
	}
	
	@Override
	public JobTitle getByTitle(String title) {
		return this.jobTitleDao.findByTitle(title).orElse(null);
	}


}
