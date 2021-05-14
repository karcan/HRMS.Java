package com.hrms.karcan.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@OneToMany(
			cascade = CascadeType.ALL,
	        mappedBy = "employer", 
	        orphanRemoval=true)
    @JsonManagedReference
    private List<EmployerPhone> phones;
}
