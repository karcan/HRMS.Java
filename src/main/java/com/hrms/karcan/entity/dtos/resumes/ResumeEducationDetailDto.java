package com.hrms.karcan.entity.dtos.resumes;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeEducationDetailDto {
	private int id;
	private String schoolName;
	private String departmentName;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	private boolean graduate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date graduateDate;
}
