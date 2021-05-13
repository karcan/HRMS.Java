package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.karcan.entity.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

}
