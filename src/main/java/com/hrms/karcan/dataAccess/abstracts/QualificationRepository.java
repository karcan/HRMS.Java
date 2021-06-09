package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.karcan.entity.concretes.Qualification;

public interface QualificationRepository extends JpaRepository<Qualification, Integer> {

}
