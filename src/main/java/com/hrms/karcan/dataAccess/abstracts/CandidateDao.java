package com.hrms.karcan.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hrms.karcan.entity.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	
	Optional<Candidate> findFirstByFirstNameIgnoreCase(@Param("firstName") String firstName);
	Optional<Candidate> findByEmailAddressIgnoreCase(@Param("emailAddress") String emailAddress);
}
