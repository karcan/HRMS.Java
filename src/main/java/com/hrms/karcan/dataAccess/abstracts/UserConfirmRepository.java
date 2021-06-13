package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserConfirmRepository {
	@Query(value = "SELECT CASE WHEN COUNT(uc) > 0 THEN true ELSE false END "
			+ "FROM UserConfirm uc "
			+ "WHERE confirmed = true "
			+ "AND userId = :userId")
	boolean isConfirmed(@Param("userId") int userId);
}
