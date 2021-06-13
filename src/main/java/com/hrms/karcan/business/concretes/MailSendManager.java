package com.hrms.karcan.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.MailSendService;
import com.hrms.karcan.core.utilities.mail.MailTemplates;
import com.hrms.karcan.core.utilities.mail.SpringMailSenderService;

@Service
public class MailSendManager implements MailSendService{
	@Autowired
	private SpringMailSenderService javaMailSenderUtils;
	
	@Override
	public void sendMail(String to, String subject, String body) {
		javaMailSenderUtils.sendMail(to, subject, MailTemplates.VERIFICATION_BODY.replace("{code}", body));
	}

}
