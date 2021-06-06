package com.hrms.karcan.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.karcan.core.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
