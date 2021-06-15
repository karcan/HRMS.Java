package com.hrms.karcan.business.constants;

public class MailTemplates {
	public static final String VERIFICATION_BODY = "Hello,\n"
			+ "\n"
			+ "We just need to verify your email address before you can access HRMS.\n"
			+ "\n"
			+ "Verify your email address {url}/{code}\n"
			+ "\n"
			+ "Thanks! The HRMS team";
	
	public static final String CANDIDATE_VERIFICATION_BODY = VERIFICATION_BODY.replace("{url}", "http://localhost:8080/api/candidate-verifications/verificate");
	public static final String EMPLOYER_VERIFICATION_BODY = VERIFICATION_BODY.replace("{url}", "http://localhost:8080/api/employer-verifications/verificate");
	public static final String EMPLOYEE_VERIFICATION_BODY = VERIFICATION_BODY.replace("{url}", "http://localhost:8080/api/employee-verifications/verificate");
}
