package com.hrms.karcan.entity.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.karcan.business.constants.ValidationMessages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resume_experiences")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResumeExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_experience_id")
	private int id;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "resume_id")
	private int resumeId;
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "company_name")
	private String companyName;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "job_title_id")
	private int jobTitleId;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "start_date")
	private Date startDate;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "is_continued")
	private boolean continued;

	@Column(name = "end_date")
	private Date endDate;
	
	//relation mapping.
	@ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "resume_id", insertable = false, updatable = false)
	private Resume resume; 
	
	@ManyToOne(targetEntity = JobTitle.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "job_title_id", insertable = false, updatable = false)
	private JobTitle jobTitle; 
	
}
