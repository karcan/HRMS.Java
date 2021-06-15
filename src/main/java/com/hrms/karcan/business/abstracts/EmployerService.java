package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.entity.tables.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	DataResult<Employer> save(Employer employer);
}
