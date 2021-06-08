package com.hrms.karcan.business.abstracts;

import com.hrms.karcan.core.utilities.result.Result;

public interface UserCheckService {
	Result checkIfEmailAlreadyExists(String email, int id);
}
