package com.hrms.karcan.business.abstracts;

import com.hrms.karcan.core.utilities.result.Result;

public interface EmployerConfirmService {
	Result confirm(int userId, int confirmerUserId);
}
