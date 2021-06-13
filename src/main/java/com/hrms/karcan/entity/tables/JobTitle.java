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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.core.entity.BaseEntity;
import com.hrms.karcan.core.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_titles")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class JobTitle extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_title_id")
	private int id;
	
	@Column(name = "title", unique = true)
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	private String title;
	
	//relation mapping.
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "created_user_id", insertable = false, updatable = false)
	private User createdUser; 
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "modified_user_id", insertable = false, updatable = false)
	private User modifiedUser; 
}