package com.hrms.karcan.dataAccess.abstracts;

import com.hrms.karcan.entity.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {
    Optional<JobTitle> findOneByTitle(@Param("") String title);
}
