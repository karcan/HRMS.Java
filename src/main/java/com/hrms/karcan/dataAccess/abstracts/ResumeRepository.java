package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.karcan.entity.concretes.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Integer> {

}
