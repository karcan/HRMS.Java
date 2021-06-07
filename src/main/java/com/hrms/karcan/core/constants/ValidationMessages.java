package com.hrms.karcan.core.constants;

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
	public static final String GRADE_MUST_BE_BETWEEN = String.format(MUST_BE_BETWEEN,1,5);
}
