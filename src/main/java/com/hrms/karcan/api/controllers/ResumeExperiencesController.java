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

import com.hrms.karcan.business.abstracts.ResumeExperienceService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.tables.ResumeExperience;

@RestController
@RequestMapping("api/resume-experiences")
public class ResumeExperiencesController {
	private ResumeExperienceService resumeExperienceService;

	@Autowired
	public ResumeExperiencesController(ResumeExperienceService resumeExperienceService) {
		this.resumeExperienceService = resumeExperienceService;
	}
	
	@GetMapping("resume-id/{resumeId}")
	public DataResult<List<ResumeExperience>> getAllByResumeId(@PathVariable("resumeId") int resumeId){
		return this.resumeExperienceService.getAllByResumeId(resumeId);
	}
	
	@GetMapping("resume-id/{resumeId}/order")
	public DataResult<List<ResumeExperience>> getAllByResumeIdOrderBy(@PathVariable("resumeId") int resumeId, Sort.Direction direciton, String fieldName ){
		return this.resumeExperienceService.getAllByResumeIdOrderBy(resumeId, direciton, fieldName);
	}
	
	@PostMapping("save")
	public ResponseEntity<Result> save(@Valid @RequestBody ResumeExperience resumeExperience) {
		Result result = this.resumeExperienceService.save(resumeExperience);
		
		if(!result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
