package com.hrms.karcan.entity.dtos.resumes;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeWebsiteDetailDto {
	private int id;
	@JsonProperty("websiteTypeId")
	private int websitetypeid;
	private String websitetypeName;
	private String website;
}
