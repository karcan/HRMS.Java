package com.hrms.karcan.core.utilities.mail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class SpringMailSenderService{
	
	private MailSender mailSender;
    private SimpleMailMessage templateMessage;

    @Autowired
    public SpringMailSenderService(MailSender mailSender) {
		this.mailSender = mailSender;
		this.templateMessage = new SimpleMailMessage();
	}
	
	public void sendMail(String to, String subject, String body) {
		templateMessage.setTo(to);
		templateMessage.setSubject(subject);
		templateMessage.setText(body);
		mailSender.send(templateMessage);
	}

	
}
