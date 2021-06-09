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

import com.hrms.karcan.business.abstracts.EmployeeService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.concretes.Employee;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {
	
	private EmployeeService employeeServie;
	
	@Autowired
	public EmployeesController(EmployeeService employeeServie) {
		this.employeeServie = employeeServie;
	}

	@GetMapping(path = "")
	public ResponseEntity<DataResult<List<Employee>>> getAll(){
		return new ResponseEntity<>(this.employeeServie.getAll(), HttpStatus.OK);
	}
	
	@PostMapping(path = "save")
	public ResponseEntity<Result> save(@Valid @RequestBody Employee employee){
		
		Result result = this.employeeServie.save(employee);
		
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
	}
}
