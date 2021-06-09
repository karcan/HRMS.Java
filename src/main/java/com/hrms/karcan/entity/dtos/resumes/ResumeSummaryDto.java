package com.hrms.karcan.entity.dtos.resumes;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResumeSummaryDto {
	private int resumeId;
	@JsonProperty("firstName")
	private String createdUserFirstName;
	@JsonProperty("lastName")
	private String createdUserLastName;
	@JsonProperty("email")
	private String createdUserEmail;
	@JsonProperty("birthDate")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createdUserBirthDate;
	private String profilePictureUrl;
	private String coverLetter;
}
