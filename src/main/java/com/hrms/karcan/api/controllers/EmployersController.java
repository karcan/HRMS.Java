package com.hrms.karcan.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.karcan.business.abstracts.EmployerService;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.entity.concretes.Employer;

@RestController
@RequestMapping("api/employers")
public class EmployersController {
	
	private EmployerService employerService;
	
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@PostMapping(path = "save")
	public Result save(@RequestBody Employer employer) {
		
		this.employerService.save(employer);
		
		return new SuccessResult("başarılı");
	}

	@GetMapping(path = "getall")
	public List<Employer> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping(path = "getbyid/{id}")
	public Employer getById(@PathVariable int id) {
		return this.employerService.getById(id);
	}
	
	@GetMapping(path = "getbyphonenumber/{phoneNumber}")
	public Employer getByPhoneId(@PathVariable String phoneNumber){
		return this.employerService.getByPhoneNumber(phoneNumber);
	}

}
