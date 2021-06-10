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

import com.hrms.karcan.business.abstracts.ResumeEducationService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.concretes.ResumeEducation;


@RestController
@RequestMapping("api/resume-educations")
public class ResumeEducationsController {

	private ResumeEducationService resumeEducationService;

	@Autowired
	public ResumeEducationsController(ResumeEducationService resumeEducationService) {
		this.resumeEducationService = resumeEducationService;
	}
	
	@GetMapping("resume-id/{resumeId}")
	public DataResult<List<ResumeEducation>> getAllByResumeId(@PathVariable("resumeId") int resumeId){
		return this.resumeEducationService.getAllByResumeId(resumeId);
	}
	
	@GetMapping("resume-id/{resumeId}/order")
	public DataResult<List<ResumeEducation>> getAllByResumeIdOrderBy(@PathVariable("resumeId") int resumeId, Sort.Direction direciton, String fieldName ){
		return this.resumeEducationService.getAllByResumeIdOrderBy(resumeId, direciton, fieldName);
	}
	
	@PostMapping("save")
	public ResponseEntity<Result> save(@Valid @RequestBody ResumeEducation resumeEducation) {
		Result result = this.resumeEducationService.save(resumeEducation);
		
		if(!result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
