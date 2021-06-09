package com.hrms.karcan.entity.dtos.resumes;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeLanguageDetailDto {
	private int id;
	@JsonProperty("languageId")
	private int languageid;
	private String languageName;
	private BigDecimal grade;
}
