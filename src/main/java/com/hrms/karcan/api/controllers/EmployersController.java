package com.hrms.karcan.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.karcan.business.abstracts.EmployerPhoneService;
import com.hrms.karcan.business.abstracts.EmployerService;
import com.hrms.karcan.entity.Employer;
import com.hrms.karcan.entity.EmployerPhone;

@RestController
@RequestMapping("api/employers")
public class EmployersController {
	
	private EmployerService employerService;
	private EmployerPhoneService employerPhoneService;
	
	public EmployersController(EmployerService employerService, EmployerPhoneService employerPhoneService) {
		super();
		this.employerService = employerService;
		this.employerPhoneService = employerPhoneService;
	}

	@GetMapping(path = "getall")
	public List<Employer> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping(path = "getphones")
	public List<EmployerPhone> getPhones(){
		return this.employerPhoneService.getAll();
	}
	
	@GetMapping(path = "getbyphonenumber/{phoneNumber}")
	public Employer getByPhoneId(@PathVariable String phoneNumber){
		return this.employerService.getByPhoneNumber(phoneNumber);
	}
}
