package com.hrms.karcan.core.utilities.result;

public class SuccessResult implements Result {
	private boolean success;
	private String message;
	
	public SuccessResult() {
		this.success = true;
	}
	
	public SuccessResult(String message) {
		this();
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}
	
}
