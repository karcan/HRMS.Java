package com.hrms.karcan.business.abstracts;

import com.hrms.karcan.core.utilities.result.Result;

public interface MailSendService {
	Result send(String email, String message);
}
