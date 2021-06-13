package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.entity.tables.Language;

public interface LanguageService {
	DataResult<List<Language>> getAllByName(String name);
	Result save(Language language);
}
