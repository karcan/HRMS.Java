package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hrms.karcan.entity.tables.UserConfirm;

public interface UserConfirmRepository extends JpaRepository<UserConfirm, Integer> {
	@Query(value = "SELECT CASE WHEN COUNT(uc) > 0 THEN true ELSE false END "
			+ "FROM UserConfirm uc "
			+ "WHERE confirmed = true "
			+ "AND userId = :userId")
	boolean isConfirmed(@Param("userId") int userId);
}
