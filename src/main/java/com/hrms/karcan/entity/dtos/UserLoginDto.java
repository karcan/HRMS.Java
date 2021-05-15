package com.hrms.karcan.entity.dtos;

import lombok.Data;

@Data
public class UserLoginDto {
	private String email;
	private String password;
}
