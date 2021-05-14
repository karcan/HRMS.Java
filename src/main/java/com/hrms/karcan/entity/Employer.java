package com.hrms.karcan.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name = "employers")
public class Employer extends User{

	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_address")
	private String webAddress;
	
	@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("employer")
    private List<EmployerPhone> phones;
}
