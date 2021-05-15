package com.hrms.karcan.entity.concretes;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="job_titles")
public class JobTitle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
}
