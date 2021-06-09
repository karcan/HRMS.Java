package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.karcan.entity.concretes.WebsiteType;

public interface WebsiteTypeRepository extends JpaRepository<WebsiteType, Integer> {

}
