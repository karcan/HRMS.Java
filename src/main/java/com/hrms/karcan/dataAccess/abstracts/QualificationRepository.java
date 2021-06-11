package com.hrms.karcan.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hrms.karcan.entity.concretes.Qualification;

public interface QualificationRepository extends JpaRepository<Qualification, Integer> {
	List<Qualification> findFirst10ByNameContainingIgnoreCase(@Param("name") String name);
}
