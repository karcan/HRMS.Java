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

import com.hrms.karcan.business.abstracts.EmployerService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.tables.Employer;


@RestController
@RequestMapping("api/employers")
public class EmployersController {
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		this.employerService = employerService;
	}
	
	@GetMapping("")
	public ResponseEntity<DataResult<List<Employer>>> getAll(){
		return new ResponseEntity<>(this.employerService.getAll(), HttpStatus.OK); 
	}

	@PostMapping("save")
	public ResponseEntity<Result> save(@Valid @RequestBody Employer employer){
		DataResult<Employer> result = this.employerService.save(employer);
		if(!result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
