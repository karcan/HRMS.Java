package com.hrms.karcan.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.karcan.business.abstracts.WebsiteTypeService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.concretes.WebsiteType;

@RestController
@RequestMapping("api/website-types")
public class WebsiteTypesController {
	
	private WebsiteTypeService websiteTypeService;

	@Autowired
	public WebsiteTypesController(WebsiteTypeService websiteTypeService) {
		this.websiteTypeService = websiteTypeService;
	}
	
	@GetMapping("")
	public ResponseEntity<DataResult<List<WebsiteType>>> getAll(){
		return new ResponseEntity<>(this.websiteTypeService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping("save")
	public ResponseEntity<Result> save(@Valid @RequestBody WebsiteType websiteType){
		Result result = this.websiteTypeService.save(websiteType);
		
		if(!result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
