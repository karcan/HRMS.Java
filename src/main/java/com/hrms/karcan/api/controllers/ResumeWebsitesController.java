package com.hrms.karcan.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.karcan.business.abstracts.ResumeWebsiteService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.dtos.resumes.ResumeWebsiteDetailDto;
import com.hrms.karcan.entity.tables.ResumeWebsite;

@RestController
@RequestMapping("api/resume-websites")
public class ResumeWebsitesController {
	private ResumeWebsiteService resumeWebsiteService;

	@Autowired
	public ResumeWebsitesController(ResumeWebsiteService resumeWebsiteService) {
		this.resumeWebsiteService = resumeWebsiteService;
	}
	
	@GetMapping("resume-id/{resumeId}")
	public ResponseEntity<DataResult<List<ResumeWebsiteDetailDto>>> getAllByResumeId(@PathVariable(name = "resumeId", required = true) int resumeId){
		return new ResponseEntity<>(this.resumeWebsiteService.getAllDetailDtoByResumeId(resumeId), HttpStatus.OK);
	}
	
	@PostMapping("save")
	public ResponseEntity<Result> save(@Valid @RequestBody ResumeWebsite resumeWebsite){
		Result result = this.resumeWebsiteService.save(resumeWebsite);
		
		if(!result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
