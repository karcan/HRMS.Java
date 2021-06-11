package com.hrms.karcan.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.karcan.business.abstracts.ResumeQualificationService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.concretes.ResumeQualification;
import com.hrms.karcan.entity.dtos.resumes.ResumeQualificationDetailDto;

@RestController
@RequestMapping("api/resume-qualifications")
public class ResumeQualificationsController {
	private ResumeQualificationService resumeQualificationService;

	@Autowired
	public ResumeQualificationsController(ResumeQualificationService resumeQualificationService) {
		this.resumeQualificationService = resumeQualificationService;
	}
	
	@GetMapping("")
	public ResponseEntity<DataResult<List<ResumeQualificationDetailDto>>> getAllByResumeId(@PathVariable("resumeId") int resumeId){
		return new ResponseEntity<>(this.resumeQualificationService.getAllDetailDtoByResumeId(resumeId), HttpStatus.OK);
	}
	
	@PostMapping("save")
	public ResponseEntity<Result> save(ResumeQualification resumeQualification){
		Result result = this.resumeQualificationService.save(resumeQualification);
		
		if(!result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
