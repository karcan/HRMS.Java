package com.hrms.karcan.entity.dtos;

import com.hrms.karcan.entity.tables.UserConfirm;
import com.hrms.karcan.entity.tables.UserVerification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerLatestVerificationAndConfirm {
	private int id;
	private UserVerification userVerification;
	private UserConfirm userConfirm;
}
