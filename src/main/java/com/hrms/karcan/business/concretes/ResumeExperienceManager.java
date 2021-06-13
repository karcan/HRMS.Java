package com.hrms.karcan.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.NullHandling;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.ResumeExperienceService;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.core.utilities.business.CheckEngine;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.ErrorResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.dataAccess.abstracts.ResumeExperienceRepository;
import com.hrms.karcan.entity.tables.ResumeExperience;

@Service
public class ResumeExperienceManager implements ResumeExperienceService {

	private ResumeExperienceRepository resumeExperienceRepository;

	@Autowired
	public ResumeExperienceManager(ResumeExperienceRepository resumeExperienceRepository) {
		this.resumeExperienceRepository = resumeExperienceRepository;
	}
	
	@Override
	public DataResult<List<ResumeExperience>> getAllByResumeId(int resumeId) {
		List<ResumeExperience> result = this.resumeExperienceRepository.findAllByResumeId(resumeId);
		return new SuccessDataResult<List<ResumeExperience>>(result);
	}
	
	@Override
	public DataResult<List<ResumeExperience>> getAllByResumeId(int resumeId, Sort sort) {
		List<ResumeExperience> result = this.resumeExperienceRepository.findAllByResumeId(resumeId, sort);
		return new SuccessDataResult<List<ResumeExperience>>(result);
	}
	
	@Override
	public DataResult<List<ResumeExperience>> getAllByResumeIdOrderBy(int id, Sort.Direction direction , String fieldName) {
		Sort.Order sortOrder = new Sort.Order(direction, fieldName, NullHandling.NULLS_LAST);
		Sort sort = Sort.by(sortOrder);

		return this.getAllByResumeId(id, sort);
	}

	@Override
	public Result save(ResumeExperience resumeExperience) {
		
		Result result = CheckEngine.run(
				checkIfIsNotContinuedThenEndDateNotNull(resumeExperience)
				);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		this.resumeExperienceRepository.save(resumeExperience);
		return new SuccessResult();
	}
	
	private Result checkIfIsNotContinuedThenEndDateNotNull(ResumeExperience resumeExperience) {
		
		if(!resumeExperience.isContinued() && resumeExperience.getEndDate() != null) {
			return new ErrorResult(ValidationMessages.IF_IS_NOT_CONTINUED_THEN_END_DATE_CAN_NOT_BE_NULL);
		}
		
		return new SuccessResult();
	}
}
