package com.hrms.karcan.api.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.karcan.business.abstracts.ResumeService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.entity.dtos.resumes.ResumeDetailDto;

import outsource.com.cloudinary.CloudinaryConfiguration;

@RestController
@RequestMapping("api/resumes")
public class ResumesController {

	private ResumeService resumeService;
	private CloudinaryConfiguration cloudinaryConfiguration;

	@Autowired
	public ResumesController(ResumeService resumeService, CloudinaryConfiguration cloudinaryConfiguration) {
		this.resumeService = resumeService;
		this.cloudinaryConfiguration = cloudinaryConfiguration;
	}
	
	@GetMapping("detail-table")
	public ResponseEntity<DataResult<List<ResumeDetailDto>>> getAllResumeDetailDto(){
		return new ResponseEntity<>(this.resumeService.getAllResumeDetailDto(), HttpStatus.OK);
	}
	
	@GetMapping("qualification-detail-table")
	public ResponseEntity<DataResult<CloudinaryConfiguration>> getAllResumeQualificationDetailDto(){
		return new ResponseEntity<>(new SuccessDataResult<CloudinaryConfiguration>(this.cloudinaryConfiguration) , HttpStatus.OK);
	}
	
	@PostMapping("{id}/set/image")
	public ResponseEntity<Result> uploadImage(@PathVariable("id") int id, @RequestParam(value="upload", required=true) MultipartFile aFile){
		
		File file = new File("");
		try {
			file = Files.createTempFile("temp", aFile.getOriginalFilename()).toFile();
			aFile.transferTo(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Result result = this.resumeService.setImage(id, file);
        
        if(!result.isSuccess()) {
        	return new ResponseEntity<Result>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Result>(result, HttpStatus.OK);
		
	}
}
