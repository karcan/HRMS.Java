package com.hrms.karcan.core.utilities.business;

import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessResult;

public class CheckEngine {
	
	public static Result run(Result... rules) {
		
		for (Result rule : rules) {
			if(!rule.isSuccess()) {
				return rule;
			}
		}
		
		return new SuccessResult();
	}
}
