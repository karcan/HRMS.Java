package com.hrms.karcan.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.karcan.business.abstracts.ResumeService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.entity.dtos.resumes.ResumeDetailDto;
import com.hrms.karcan.entity.dtos.resumes.ResumeQualificationDetailDto;

@RestController
@RequestMapping("api/resumes")
public class ResumesController {

	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		this.resumeService = resumeService;
	}
	
	@GetMapping("detail-table")
	public ResponseEntity<DataResult<List<ResumeDetailDto>>> getAllResumeDetailDto(){
		return new ResponseEntity<>(this.resumeService.getAllResumeDetailDto(), HttpStatus.OK);
	}
	
	@GetMapping("qualification-detail-table")
	public ResponseEntity<DataResult<List<ResumeQualificationDetailDto>>> getAllResumeQualificationDetailDto(){
		return new ResponseEntity<>(this.resumeService.getAllResumeQualificationDetailDto(), HttpStatus.OK);
	}
}
