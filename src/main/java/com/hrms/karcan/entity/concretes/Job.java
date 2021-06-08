package com.hrms.karcan.entity.concretes;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.core.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "jobs")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Job extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private int id;
	
	@JsonIgnore(false)
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "created_user_id")
	private int createdUserId;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "state_id")
	private int stateId;
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "title")
	private String title;
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "description")
	private String description;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "job_title_id")
	private int jobTitleId;
	
	@Column(name = "min_salary")
	private BigDecimal minSalary;
	
	@Column(name = "max_salary")
	private BigDecimal maxSalary;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "applicant_quota")
	private BigDecimal applicantQuota;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "last_application_date")
	private Date lastApplicationDate;

	
	// relation mapping.
	@ManyToOne(targetEntity = State.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "state_id" , insertable = false, updatable = false)
	private State state;
	
	@ManyToOne(targetEntity = JobTitle.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "job_title_id", insertable = false, updatable = false)
	private JobTitle jobTitle;
	
	@ManyToOne(targetEntity = Employer.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "created_user_id", insertable = false, updatable = false)
	private Employer createdUser; 
}
