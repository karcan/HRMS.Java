package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.entity.Candidate;

public interface CandidateService {
	void save(Candidate candidate);
	List<Candidate> getAll();
	Candidate getByFirstName(String string);
	Candidate getByEmailAddress(String string);
}
