package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.tables.WebsiteType;

public interface WebsiteTypeService {
	DataResult<List<WebsiteType>> getAll();
	Result save(WebsiteType websiteType);
}
