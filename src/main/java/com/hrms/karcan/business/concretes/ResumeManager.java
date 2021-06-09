package com.hrms.karcan.business.concretes;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.ResumeService;
import com.hrms.karcan.core.utilities.mappers.ModelMapperUtils;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.dataAccess.abstracts.ResumeQualificationRepository;
import com.hrms.karcan.dataAccess.abstracts.ResumeRepository;
import com.hrms.karcan.entity.dtos.resumes.ResumeDetailDto;
import com.hrms.karcan.entity.dtos.resumes.ResumeQualificationDetailDto;

import net.bytebuddy.asm.Advice.This;


@Service
public class ResumeManager implements ResumeService {

	private ResumeRepository resumeRepository;
	private ResumeQualificationRepository resumeQualificationRepository;
	
	@Autowired
	public ResumeManager(ResumeRepository resumeRepository, ResumeQualificationRepository resumeQualificationRepository) {
		this.resumeRepository = resumeRepository;
		this.resumeQualificationRepository = resumeQualificationRepository;
	}

	@Override
	public DataResult<List<ResumeDetailDto>> getAllResumeDetailDto() {
		return new SuccessDataResult<List<ResumeDetailDto>>(ModelMapperUtils.toList(
				this.resumeRepository.findAll(),
				ResumeDetailDto.class)
				);
	}

	@Override
	public DataResult<ResumeDetailDto> getResumeDetailDtoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<ResumeQualificationDetailDto>> getAllResumeQualificationDetailDto() {
		return new SuccessDataResult<List<ResumeQualificationDetailDto>>(ModelMapperUtils.toList(
				this.resumeQualificationRepository.findAll(), 
				ResumeQualificationDetailDto.class)
				);

	}
	

}
