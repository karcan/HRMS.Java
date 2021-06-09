package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.concretes.Employee;

public interface EmployeeService {
	Result save(Employee employee);
	DataResult<List<Employee>> getAll();
}
