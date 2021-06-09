package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.karcan.entity.concretes.ResumeQualification;

public interface ResumeQualificationRepository extends JpaRepository<ResumeQualification, Integer> {

}
