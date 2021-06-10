package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.LanguageService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.dataAccess.abstracts.LanguageRepository;
import com.hrms.karcan.entity.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public DataResult<List<Language>> getAllByName(String name) {
		return new SuccessDataResult<List<Language>>(this.languageRepository.findAllFirst10ByNameContainingIgnoreCase(name));
	}

	@Override
	public Result save(Language language) {
		this.languageRepository.save(language);
		return new SuccessResult();
	}
	
}
