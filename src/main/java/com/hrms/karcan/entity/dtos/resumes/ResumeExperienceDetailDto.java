package com.hrms.karcan.entity.dtos.resumes;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeExperienceDetailDto {
	private int id;
	private String companyName;
	private int jobtitleid;
	private String jobTitleTitle;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	private boolean continued;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
}
