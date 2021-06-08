package com.hrms.karcan.business.concretes;

import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.MailSendService;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessResult;

@Service
public class MailSendManager implements MailSendService {

	@Override
	public Result send(String email, String message) {
		return new SuccessResult(message);
	}

}
