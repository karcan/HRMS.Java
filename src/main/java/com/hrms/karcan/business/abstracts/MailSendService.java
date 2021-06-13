package com.hrms.karcan.business.abstracts;


public interface MailSendService {
	void sendMail(String to, String subject, String body);
}
