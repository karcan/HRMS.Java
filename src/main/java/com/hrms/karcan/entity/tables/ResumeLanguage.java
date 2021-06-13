package com.hrms.karcan.entity.tables;

import java.math.BigDecimal;
import java.time.Instant;

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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.karcan.business.constants.ValidationMessages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resume_languages")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResumeLanguage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_language_id")
	private int id;
	
	@CreatedDate
	@JsonIgnore
    @Column(name = "created_date", updatable = false)
    private Instant createdDate = Instant.now();
	
	@LastModifiedDate
	@JsonIgnore
    @Column(name = "modified_date")
    private Instant modifiedDate = Instant.now();
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "resume_id")
	private int resumeId;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "language_id")
	private int languageId;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Size(min = 1, max = 5, message = ValidationMessages.GRADE_MUST_BE_BETWEEN)
	@Column(name = "grade")
	private BigDecimal grade;
	
	//relation mapping
	@ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "resume_id", insertable = false, updatable = false)
	private Resume resume; 
	
	@ManyToOne(targetEntity = Language.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "language_id", insertable = false, updatable = false)
	private Language language; 
}
