package com.hrms.karcan.entity.dtos.resumes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ResumeDetailDto extends ResumeSummaryDto {

	@JsonProperty("qualificationInformations")
	public List<ResumeQualificationDetailDto> resumeQualifications; 
	
	@JsonProperty("websiteInformations")
	public List<ResumeWebsiteDetailDto> resumeWebsites;
	
	@JsonProperty("languageInformations")
	public List<ResumeLanguageDetailDto> resumeLanguages; 
	
	@JsonProperty("educationInformations")
	public List<ResumeEducationDetailDto> resumeEducations;
	
	@JsonProperty("experienceInformations")
	public List<ResumeExperienceDetailDto> resumeExperiences;
	
}
