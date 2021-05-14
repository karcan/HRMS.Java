package com.hrms.karcan.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
@Entity
@Table(name="employer_phones")
public class EmployerPhone{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "employer_id")
    @JsonBackReference
	private Employer employer;

	@Column(name = "phone_number")
	private String phoneNumber;

	
}
