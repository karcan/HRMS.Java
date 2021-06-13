package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.karcan.entity.tables.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
