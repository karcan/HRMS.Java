package com.hrms.karcan.entity.concretes;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.karcan.business.constants.ValidationMessages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resume_qualifications")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResumeQualification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_qualification_id")
	private int id;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "resume_id")
	private int resumeId;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "qualification_id")
	private int qualificationId;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Size(min = 1, max = 5, message = ValidationMessages.GRADE_MUST_BE_BETWEEN)
	@Column(name = "grade")
	private BigDecimal grade;
	
	//relation mapping
	@ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "resume_id", insertable = false, updatable = false)
	private Resume resume; 
	
	@ManyToOne(targetEntity = Qualification.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "qualification_id", insertable = false, updatable = false)
	private Qualification qualification; 
}
