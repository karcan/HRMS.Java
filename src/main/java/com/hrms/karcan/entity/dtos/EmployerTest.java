package com.hrms.karcan.entity.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class EmployerTest {
	private int id;
	private boolean verificated;
	private boolean confirmed;
}
