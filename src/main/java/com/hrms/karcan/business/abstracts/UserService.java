package com.hrms.karcan.business.abstracts;

import com.hrms.karcan.entity.concretes.User;

public interface UserService {
	void save(User user);
	User findByEmailAddressAndPassword(String email, String password);
}
