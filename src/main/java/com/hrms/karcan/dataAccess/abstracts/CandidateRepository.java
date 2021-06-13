package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hrms.karcan.entity.tables.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
	boolean existsByIdentityNumberAndIdNot(@Param("identityNumber") String identityNumber, @Param("id") int id);
}
