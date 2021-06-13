package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.tables.Employer;

public interface EmployerService {
	List<Employer> getAll();
	Result save(Employer employer);
}
