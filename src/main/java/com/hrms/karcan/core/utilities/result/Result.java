package com.hrms.karcan.core.utilities.result;

import lombok.Data;

@Data
public abstract class Result {
	private final boolean success;
	private String message;
		
	public Result(boolean success) {
		this.success = success;
	}
	public Result(boolean success, String message) {
		this(success);
		this.message = message;
	}
	
}
