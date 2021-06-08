package com.hrms.karcan.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.karcan.business.abstracts.JobService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.entity.concretes.Job;

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

	@PostMapping("save")
	public ResponseEntity<Result> save(@Valid @RequestBody Job job) {

		Result result = this.jobService.save(job);

		if (!result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(new SuccessResult(), HttpStatus.OK);
	}
}
