package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hrms.karcan.entity.tables.UserVerification;

public interface UserVerificationRepository extends JpaRepository<UserVerification, Integer> {
	
	@Query(value = "SELECT CASE WHEN COUNT(uv) > 0 THEN true ELSE false END "
			+ "FROM UserVerification uv "
			+ "WHERE verificationDate is NOT NULL "
			+ "AND userId = :userId")
	boolean userIsVerificated(@Param("userId") int userId);
	
	UserVerification findByCode(@Param("code") String code);
	boolean existsByCode(@Param("code") String code);
	
	@Query(value = "SELECT uv.userId FROM UserVerification uv WHERE uv.code = :code")
	int findUserIdByCode(@Param("code") String code);
}
