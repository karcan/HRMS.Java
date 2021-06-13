package com.hrms.karcan.business.abstracts;

import java.util.List;

import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.entity.tables.Candidate;

public interface CandidateService {
	DataResult<Candidate> save(Candidate candidate);
	DataResult<List<Candidate>> getAll();
}
