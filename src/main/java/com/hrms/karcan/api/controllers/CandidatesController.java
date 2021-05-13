package com.hrms.karcan.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.karcan.business.abstracts.CandidateService;
import com.hrms.karcan.entity.Candidate;

@RestController
@RequestMapping(path = "/api/candidates/")
public class CandidatesController {

	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping(path = "getall")
	public List<Candidate> getAll(){
		return this.candidateService.getAll();
	};
	
}
