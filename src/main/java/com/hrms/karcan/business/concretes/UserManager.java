package com.hrms.karcan.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.UserService;
import com.hrms.karcan.dataAccess.abstracts.UserDao;
import com.hrms.karcan.entity.concretes.User;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public User findByEmailAddressAndPassword(String email, String password) {
		return this.userDao.findByEmailAddressAndPassword(email, password).orElse(null); 
	}

	@Override
	public void save(User user) {
		this.userDao.save(user);
		
	}
	
}
