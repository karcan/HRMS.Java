package com.hrms.karcan.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.karcan.business.abstracts.JobService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.entity.dtos.JobSummaryDto;
import com.hrms.karcan.entity.tables.Job;

@RestController
@RequestMapping(path = "/api/jobs")
public class JobsController {

	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		this.jobService = jobService;
	}

	@GetMapping("")
	public ResponseEntity<DataResult<List<Job>>> getAll() {
		return new ResponseEntity<>(this.jobService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("summary-table")
	public ResponseEntity<DataResult<List<JobSummaryDto>>> getAllJobSummaryDto(){
		return new ResponseEntity<>(this.jobService.getAllJobSummaryDto(), HttpStatus.OK); 
	}
	
	@GetMapping("summary-table/order")
	public ResponseEntity<DataResult<List<JobSummaryDto>>> getAllJobSummaryDto(Sort.Direction sort, String property){
		return new ResponseEntity<>(this.jobService.getAllJobSummaryDtoSorted(sort, property), HttpStatus.OK); 
	}
	
	@GetMapping("summary-table/contains/company-name")
	public ResponseEntity<DataResult<List<JobSummaryDto>>> getAllJobSummaryDtoByCompanyName(String companyName){
		return new ResponseEntity<>(this.jobService.getAllJobSummaryDtoByCompanyName(companyName), HttpStatus.OK); 
	}
	
	@GetMapping("summary-table/contains/job-title")
	public ResponseEntity<DataResult<List<JobSummaryDto>>> getAllJobSummaryDtoByJobTitle(String jobTitle){
		return new ResponseEntity<>(this.jobService.getAllJobSummaryDtoByJobTitle(jobTitle), HttpStatus.OK); 
	}

	@PostMapping("save")
	public ResponseEntity<Result> save(@Valid @RequestBody Job job) {

		Result result = this.jobService.save(job);

		if (!result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(new SuccessResult(), HttpStatus.OK);
	}
	
	@PostMapping("{id}/set/active")
	public ResponseEntity<Result> setActive(@PathVariable(name = "id") int id){
		return this.setActiveAndPassive(id, true);
	}
	
	@PostMapping("{id}/set/passive")
	public ResponseEntity<Result> setPassive(@PathVariable(name = "id") int id){
		return this.setActiveAndPassive(id, false);
	}
	
	private ResponseEntity<Result> setActiveAndPassive(int id, boolean status){
		Result result = this.jobService.setActive(id, status);
		
		if (!result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(new SuccessResult(), HttpStatus.OK);
	}
}
