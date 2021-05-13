package com.hrms.karcan.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.karcan.business.abstracts.JobTitleService;
import com.hrms.karcan.entity.JobTitle;

@RestController
@RequestMapping("api/job-titles")
public class JobTitlesController {
	
	private final JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("getall")
	public List<JobTitle> getAll(){
		return jobTitleService.getAll();
	}
	
	@GetMapping("getbyid/{id}")
	public JobTitle getById(@PathVariable int id) {
		return jobTitleService.getById(id);
	}

}
