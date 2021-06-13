package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.EmployeeService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.dataAccess.abstracts.EmployeeRepository;
import com.hrms.karcan.entity.tables.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeManager(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Result save(Employee employee) {
		this.employeeRepository.save(employee);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeRepository.findAll());
	}

}
