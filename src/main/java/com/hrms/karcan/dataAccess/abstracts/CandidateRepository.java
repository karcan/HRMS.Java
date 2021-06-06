package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.karcan.entity.concretes.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
	
}
