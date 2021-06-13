package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.WebsiteTypeService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.dataAccess.abstracts.WebsiteTypeRepository;
import com.hrms.karcan.entity.tables.WebsiteType;

@Service
public class WebsiteTypeManager implements WebsiteTypeService {

	private WebsiteTypeRepository websiteTypeRepository;
	
	@Autowired
	public WebsiteTypeManager(WebsiteTypeRepository websiteTypeRepository) {
		this.websiteTypeRepository = websiteTypeRepository;
	}

	@Override
	public DataResult<List<WebsiteType>> getAll() {
		return new SuccessDataResult<List<WebsiteType>>(this.websiteTypeRepository.findAll());
	}

	@Override
	public Result save(WebsiteType websiteType) {
		this.websiteTypeRepository.save(websiteType);
		
		return new SuccessResult();
	}

}
