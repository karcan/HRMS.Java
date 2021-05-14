package com.hrms.karcan.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@Column(name="password")
	private String password;
}
