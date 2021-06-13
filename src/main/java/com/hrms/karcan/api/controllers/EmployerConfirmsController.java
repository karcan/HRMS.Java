package com.hrms.karcan.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.karcan.business.abstracts.EmployerConfirmService;
import com.hrms.karcan.core.utilities.result.Result;

@RestController
@RequestMapping("api/employer-confirms")
public class EmployerConfirmsController {
	private EmployerConfirmService employerConfirmService;
	
	@Autowired
	public EmployerConfirmsController(EmployerConfirmService employerConfirmService) {
		this.employerConfirmService = employerConfirmService;
	}
	
	@PostMapping("confirm") 
	public ResponseEntity<Result> confirm(@RequestParam int userId, @RequestParam int confirmerUserId){
		Result result = this.employerConfirmService.confirm(userId, confirmerUserId);
		if(!result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
