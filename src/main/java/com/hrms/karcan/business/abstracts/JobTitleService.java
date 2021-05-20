package com.hrms.karcan.business.abstracts;

import com.hrms.karcan.entity.concretes.JobTitle;
import java.util.List;
import java.util.Optional;

public interface JobTitleService {
    void save(JobTitle jobTitle);
    List<JobTitle> findAll();
    Optional<JobTitle> findOneByTitle(String title);
}
