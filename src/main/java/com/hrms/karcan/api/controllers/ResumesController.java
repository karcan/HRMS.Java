package com.hrms.karcan.api.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.karcan.business.abstracts.ResumeService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.dtos.resumes.ResumeDetailDto;
import com.hrms.karcan.entity.dtos.resumes.ResumeSummaryDto;
import com.hrms.karcan.entity.tables.Resume;


@RestController
@RequestMapping("api/resumes")
public class ResumesController {

	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		this.resumeService = resumeService;
	}
	
	@GetMapping("summary-table")
	public ResponseEntity<DataResult<List<ResumeSummaryDto>>> getAllSummaryDto(){
		return new ResponseEntity<>(this.resumeService.getAllSummaryDto(), HttpStatus.OK);
	}
	
	@GetMapping("{id}/detail-table")
	public ResponseEntity<DataResult<List<ResumeDetailDto>>> getDetailDtoById(@PathVariable(name = "id", required = true) int id){
		return new ResponseEntity<>(this.resumeService.getDetailDtoById(id), HttpStatus.OK);
	}

	@PostMapping("{id}/set/image")
	public ResponseEntity<Result> uploadImage(@PathVariable("id") int id, @RequestParam(value="file", required=true) MultipartFile aFile) throws IOException{
		
		File file = new File("");
		file = Files.createTempFile("temp", aFile.getOriginalFilename()).toFile();
		aFile.transferTo(file);
		
        Result result = this.resumeService.setImage(id, file);
        
        if(!result.isSuccess()) {
        	return new ResponseEntity<Result>(HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<Result>(result, HttpStatus.OK);
	}
	
	@PostMapping("save")
	public ResponseEntity<Result> save(@Valid @RequestBody Resume resume){
		Result result = this.resumeService.save(resume);
		
		if(!result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
