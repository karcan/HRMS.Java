package com.hrms.karcan.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.CandidateVerificationService;
import com.hrms.karcan.business.abstracts.UserVerificationManager;
import com.hrms.karcan.core.dataAccess.abstracts.UserRepository;
import com.hrms.karcan.core.entity.User;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.ErrorDataResult;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;
import com.hrms.karcan.dataAccess.abstracts.UserVerificationRepository;
import com.hrms.karcan.entity.tables.UserVerification;

@Service 
public class CandidateVerificationManager extends UserVerificationManager implements CandidateVerificationService {
	private UserRepository userRepository;
	
	@Autowired
	public CandidateVerificationManager(UserVerificationRepository userVerificationRepository, UserRepository userRepository) {
		super(userVerificationRepository);
		this.userRepository = userRepository;
	}
	
	@Override
	public DataResult<UserVerification> verificate(String code) {
	   DataResult<UserVerification> userVerification = super.verificate(code);
	   
	   if(!userVerification.isSuccess()) {
		   return new ErrorDataResult<UserVerification>(userVerification.getMessage(),null);
	   }
	   
	   User user =  this.userRepository.getById(userVerification.getData().getUserId());
	   if(user != null) {
		   user.setActive(true);
		   this.userRepository.save(user);
	   }
	   
	   return new SuccessDataResult<UserVerification>(null); 
	}
}
