package com.hrms.karcan.entity.tables;

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
@Table(name = "resume_websites")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResumeWebsite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_website_id")
	private int id;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "resume_id")
	private int resumeId;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "website_type_id")
	private int websiteTypeId;
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "website")
	private String website;
	
	//relation mapping
	@ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "resume_id", insertable = false, updatable = false)
	private Resume resume; 
	
	@ManyToOne(targetEntity = WebsiteType.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "website_type_id", insertable = false, updatable = false)
	private WebsiteType websiteType; 
}
