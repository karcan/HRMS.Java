package com.hrms.karcan.business.concretes;

import com.hrms.karcan.business.abstracts.JobTitleService;
import com.hrms.karcan.dataAccess.abstracts.JobTitleDao;
import com.hrms.karcan.entity.concretes.JobTitle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;

    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }


    @Override
    public void save(JobTitle jobTitle) {
        this.jobTitleDao.save(jobTitle);
    }

    @Override
    public List<JobTitle> findAll() {
        return this.jobTitleDao.findAll();
    }

    @Override
    public Optional<JobTitle> findOneByTitle(String title) {
        return this.jobTitleDao.findOneByTitle(title);
    }
}
