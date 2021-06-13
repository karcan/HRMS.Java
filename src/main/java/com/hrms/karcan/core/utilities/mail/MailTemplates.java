package com.hrms.karcan.core.utilities.mail;

public class MailTemplates {
	public static final String VERIFICATION_BODY = "Hello,\r\n"
			+ "\r\n"
			+ "We just need to verify your email address before you can access HRMS.\r\n"
			+ "\r\n"
			+ "Verify your email address http://localhost:8080/api/user-verifications/verificate/{code}\r\n"
			+ "\r\n"
			+ "Thanks! The HRMS team";
}
