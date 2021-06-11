package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hrms.karcan.business.abstracts.QualificationService;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.dataAccess.abstracts.QualificationRepository;
import com.hrms.karcan.entity.concretes.Qualification;

public class QualificationManager implements QualificationService {
	private QualificationRepository qualificationRepository;

	@Autowired
	public QualificationManager(QualificationRepository qualificationRepository) {
		this.qualificationRepository = qualificationRepository;
	}

	@Override
	public DataResult<List<Qualification>> getAllByName(String name) {
		return new SuccessDataResult<List<Qualification>>(this.qualificationRepository.findFirst10ByNameContainingIgnoreCase(name));
	}

	@Override
	public Result save(Qualification qualification) {
		this.qualificationRepository.save(qualification);
		return new SuccessResult();
	}
	
	
}
