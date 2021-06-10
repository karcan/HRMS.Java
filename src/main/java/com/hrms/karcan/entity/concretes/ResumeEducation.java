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
@Table(name = "resume_educations")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResumeEducation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_education_id")
	private int id;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "resume_id")
	private int resumeId;
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "school_name")
	private String schoolName;
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "department_name")
	private String departmentName;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "start_date")
	private Date startDate;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "is_graduate")
	private boolean graduate;
	
	@Column(name = "graduate_date")
	private Date graduateDate;
	
	//relation mapping.
	@ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "resume_id", insertable = false, updatable = false)
	private Resume resume; 
}
