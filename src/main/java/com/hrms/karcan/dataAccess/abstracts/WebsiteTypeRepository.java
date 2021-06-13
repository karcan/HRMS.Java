package com.hrms.karcan.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.karcan.entity.tables.WebsiteType;

public interface WebsiteTypeRepository extends JpaRepository<WebsiteType, Integer> {

}
