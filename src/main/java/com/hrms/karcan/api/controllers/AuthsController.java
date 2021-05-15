package com.hrms.karcan.api.controllers;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hrms.karcan.business.abstracts.IdentityValidationService;
import com.hrms.karcan.business.abstracts.UserService;
import com.hrms.karcan.business.adapters.MernisServiceAdapter;
import com.hrms.karcan.core.utilities.result.ErrorResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessResult;
import com.hrms.karcan.entity.concretes.Candidate;
import com.hrms.karcan.entity.concretes.Employer;
import com.hrms.karcan.entity.concretes.User;
import com.hrms.karcan.entity.dtos.UserLoginDto;


@RestController
@RequestMapping("api/auth")
public class AuthsController {

	private UserService userService;
	private IdentityValidationService identityValidationService;

	@Autowired
	public AuthsController(UserService userService, IdentityValidationService identityValidationService) {
		super();
		this.userService = userService;
		this.identityValidationService = identityValidationService;
	}

	@PostMapping("login")
	public ResponseEntity<Result> login(@RequestBody() UserLoginDto userLoginDto) {
		
		Base64 base64 = new Base64();
		String password = new String(base64.decode(userLoginDto.getPassword().getBytes()));
		User user = this.userService.findByEmailAddressAndPassword(userLoginDto.getEmail(), password);
		
		if(user == null) {
			return ResponseEntity.status(400).body(new ErrorResult("User not found."));
		}
		return ResponseEntity.status(200).body(new SuccessResult());
	}
	
	@PostMapping(path = "mernis")
	public ResponseEntity<Result> mernis(@RequestBody() UserLoginDto userLoginDto){
		Base64 base64 = new Base64();
		String password = new String(base64.decode(userLoginDto.getPassword().getBytes()));
		User user = this.userService.findByEmailAddressAndPassword(userLoginDto.getEmail(), password);
		Candidate candidate = (Candidate)user;
		Result result = this.identityValidationService.CheckIfRealPerson(candidate.getIdentificationNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate());
		
		if(!result.isSuccess()) {
			return ResponseEntity.status(400).body(result);
		}
		
		return ResponseEntity.status(200).body(new SuccessResult());
	}
	
	@PostMapping(path = "register/employer")
	public User register(@RequestBody(required = true) Employer employer) {
		userService.save(employer);
		return employer;
	}
	
	@PostMapping(path = "register/candidate")
	public User register(@RequestBody(required = true) Candidate candidate) { 
		userService.save(candidate);
		return candidate;
	}
	
}
