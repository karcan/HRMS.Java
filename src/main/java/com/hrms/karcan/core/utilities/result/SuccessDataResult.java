package com.hrms.karcan.core.utilities.result;

public class SuccessDataResult<T> extends DataResult<T> {
	
	public SuccessDataResult(T data) {
		super(true, data);
	}
	
	public SuccessDataResult(String message, T data) {
		super(true, message, data);
	}
}
