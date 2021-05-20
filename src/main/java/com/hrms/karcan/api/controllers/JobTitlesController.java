package com.hrms.karcan.api.controllers;

import com.hrms.karcan.business.abstracts.JobTitleService;
import com.hrms.karcan.entity.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/job-titles")
public class JobTitlesController {
    private final JobTitleService jobTitleService;

    public JobTitlesController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping(path = "getall")
    public List<JobTitle> getAll(){
        return this.jobTitleService.findAll();
    }

}
