package com.hrms.karcan.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="job_titles")
public class JobTitle {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
}
