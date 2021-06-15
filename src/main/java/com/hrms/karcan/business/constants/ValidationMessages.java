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
	public static final String RESUME_IS_NOT_EXISTS = "Resume not found.";
	public static final String IF_IS_GRADUATE_THEN_GRADUATE_DATE_CAN_NOT_BE_NULL = "When is graduate, the graduate date cannot be blank.";
	public static final String IF_IS_NOT_CONTINUED_THEN_END_DATE_CAN_NOT_BE_NULL = "When is not continued, the end date cannot be blank.";
	public static final String VERIFICATION_CODE_IS_NOT_EXISTS = "The verification code not found.";
	public static final String USER_IS_ALREADY_VERIFICATED = "The user already verificated.";
	public static final String USER_IS_MUST_BE_VERIFIED_FIRST = "You must be verified first.";
	public static final String USER_IS_ALREADY_CONFIRMED = "The user already confirmed.";
	public static final String CONFIRMER_IS_NOT_EMPLOYEE = "The user is not employee.";
	public static final String USER_IS_NOT_EMPLOYER = "The user is not employer.";
	public static final String JOB_IS_NOT_FOUND = "Job is not found.";
}
