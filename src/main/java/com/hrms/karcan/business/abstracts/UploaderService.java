package com.hrms.karcan.business.abstracts;

import java.io.File;

import com.hrms.karcan.core.utilities.result.Result;

public interface UploaderService {
	Result imageUpload(File file);
}
