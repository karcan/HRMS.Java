package com.hrms.karcan.business.abstracts;

import com.hrms.karcan.core.utilities.result.Result;

public interface AuthService {
	Result login(String emailAdress, String password);
}
