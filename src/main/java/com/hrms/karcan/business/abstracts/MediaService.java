package com.hrms.karcan.business.abstracts;

import java.io.File;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.MediaResult;

public interface MediaService {
	DataResult<MediaResult> setImage(File file);
}
