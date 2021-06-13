package com.hrms.karcan.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.karcan.business.abstracts.CandidateService;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.ErrorDataResult;
import com.hrms.karcan.entity.tables.Candidate;


@RestController
@RequestMapping(path = "api/candidates")
public class CandidatesController {

	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	@GetMapping(path = "")
	public ResponseEntity<DataResult<List<Candidate>>> getAll(){
		return new ResponseEntity<>(this.candidateService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping(path = "save")
	public ResponseEntity<DataResult<Candidate>> save(@Valid @RequestBody Candidate candidate){
		
		DataResult<Candidate> result = this.candidateService.save(candidate);
		
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(ValidationMessages.VALIDATION_ERROR,validationErrors);
		return errors;
	}
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleSqlConstraintException(ConstraintViolationException exceptions)
	{
		Map<String, String> validationError = new HashMap<String, String>();
		validationError.put("message", exceptions.getCause().getMessage());
		validationError.put("constraint", exceptions.getConstraintName());
		return new ErrorDataResult<Object>(validationError);
	}
	
}
