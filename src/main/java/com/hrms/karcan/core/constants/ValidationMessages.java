package com.hrms.karcan.core.constants;

public class ValidationMessages {
	public static final String MAXLENGTH_STRING = "should not be greater than"; 
	public static final String SHOULDBEVALID_STRING = "should be valid.";
	
	public static final String notBlankTitle = "";
	public static final String personIdentityValidationError = "Kimlik doğrulaması başarısız";
	public static final String notBlank = "must not be empty or null";
	public static final String emailMaxLength = MAXLENGTH_STRING + " 150";
	public static final String passwordMaxLength = MAXLENGTH_STRING + " 25";

	public static final String emailFormat = SHOULDBEVALID_STRING;
}
