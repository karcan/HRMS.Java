package com.hrms.karcan.entity.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.core.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User {
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "company_name")
	private String companyName;
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "website")
	private String website; 
}
