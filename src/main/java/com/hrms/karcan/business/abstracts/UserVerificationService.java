package com.hrms.karcan.business.abstracts;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.entity.tables.UserVerification;

public interface UserVerificationService {
	DataResult<UserVerification> generate(int userId);
	abstract DataResult<UserVerification> verificate(String code);
}
