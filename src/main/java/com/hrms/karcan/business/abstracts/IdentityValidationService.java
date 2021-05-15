package com.hrms.karcan.business.abstracts;

import java.util.Date;

import com.hrms.karcan.core.utilities.result.Result;

public interface IdentityValidationService {
	Result CheckIfRealPerson(Long identityNumber, String firstName, String lastName, int birthYear);
	Result CheckIfRealPerson(String identityNumber, String firstName, String lastName, Date birthDate);
	Result CheckIfRealPerson(Long identityNumber, String firstName, String lastName, Date birthDate);
}
