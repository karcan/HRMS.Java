package com.hrms.karcan.business.constants;

public class ValidationMessages {
	public static final String VALIDATION_ERROR = "Validation Error(s)";
	public static final String MAX_LENGTH = "should not be greater than"; 
	public static final String SHOULD_BE_VALID = "should be valid.";
	public static final String MUST_BE_BETWEEN = "must be between %d and %d";
	
	public static final String PERSON_ID_VERIFICATION = "Kimlik doğrulaması başarısız";
	public static final String NOT_BLANK = "must not be empty or null";
	public static final String EMAIL_MAX_LENGTH = MAX_LENGTH + " 150";
	public static final String PASSWORD_MAX_LENGTH = MAX_LENGTH + " 25";

	public static final String EMAIL_VERIFICATION = SHOULD_BE_VALID;
	public static final String GRADE_MUST_BE_BETWEEN = "Must be between 1 and 5";
	public static final String USER_EMAIL_IS_ALREADY_EXISTS = "E-mail is already taken.";
	public static final String USER_IDENTITY_NUMBER_IS_ALREADY_EXISTS = "Identification Number is already taken.";
	public static final String EMAIL_AND_WEBSITE_MUST_BE_THE_SAME = "E-mail and Website must be the same.";
	public static final String JOB_TITLE_ALREADY_EXISTS = "Title is already exists.";
}
