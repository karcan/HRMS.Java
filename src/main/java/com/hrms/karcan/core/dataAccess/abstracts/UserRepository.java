package com.hrms.karcan.core.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hrms.karcan.core.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsByEmailAndIdNot(@Param("email") String email, @Param("id") int id);
}
