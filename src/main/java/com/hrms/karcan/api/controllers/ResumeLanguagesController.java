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

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.dtos.resumes.ResumeLanguageDetailDto;
import com.hrms.karcan.entity.tables.ResumeLanguage;
import com.hrms.karcan.business.abstracts.ResumeLanguageService;

@RestController
@RequestMapping("api/resume-languages")
public class ResumeLanguagesController {
	private ResumeLanguageService resumeLanguageService;

	@Autowired
	public ResumeLanguagesController(ResumeLanguageService resumeLanguageService) {
		this.resumeLanguageService = resumeLanguageService;
	}
	
	@GetMapping("resume-id/{resumeId}")
	public ResponseEntity<DataResult<List<ResumeLanguageDetailDto>>> getAllByResumeId(@PathVariable("resumeId") int resumeId){
		return new ResponseEntity<>(this.resumeLanguageService.getAllDetailDtoByResumeId(resumeId), HttpStatus.OK);
	}
	
	@PostMapping("save")
	public ResponseEntity<Result> save(@Valid @RequestBody ResumeLanguage resumeLanguage){
		Result result = this.resumeLanguageService.save(resumeLanguage);
		if(!result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
