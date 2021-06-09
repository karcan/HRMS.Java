package com.hrms.karcan.entity.dtos.resumes;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeQualificationDetailDto {
	
	private int id;
	@JsonProperty("qualificationId")
	private int qualificationid;
	private String qualificationName;
	private BigDecimal grade;

}
