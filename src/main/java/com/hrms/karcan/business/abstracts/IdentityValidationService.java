package com.hrms.karcan.business.abstracts;

import java.util.Date;

import com.hrms.karcan.core.utilities.result.Result;

public interface IdentityValidationService {
	Result checkIdentityNumber(String identityNumber, String firstName, String lastName, Date birthDate);
}
