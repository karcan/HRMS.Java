package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.concretes.Qualification;

public interface QualificationService {
	DataResult<List<Qualification>> getAllByName(String name);
	Result save(Qualification qualification);
}
