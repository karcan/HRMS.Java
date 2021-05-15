package com.hrms.karcan.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hrms.karcan.business.abstracts.JobTitleService;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.entity.concretes.JobTitle;

@RestController
@RequestMapping("api/job-titles")
public class JobTitlesController {
	
	private final JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@PostMapping("save")
	public Result save(@RequestBody JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return new SuccessResult("başarılı");
	}
	
	@GetMapping("getall")
	public List<JobTitle> getAll(){
		return jobTitleService.getAll();
	}
	
	@GetMapping("getbyid/{id}")
	public JobTitle getById(@PathVariable int id) {
		return jobTitleService.getById(id);
	}
	
	@GetMapping("getbytitle/{title}") 
	public JobTitle getByTitle(@PathVariable String title) {
		return jobTitleService.getByTitle(title);
	}

}
