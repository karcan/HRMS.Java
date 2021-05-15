package com.hrms.karcan.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hrms.karcan.entity.concretes.User;


public interface UserDao extends JpaRepository<User, Integer> {
	Optional<User> findByEmailAddressAndPassword(@Param("emailAddress") String email, @Param("password") String password);
}
