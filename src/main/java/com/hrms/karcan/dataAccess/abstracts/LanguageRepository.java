package com.hrms.karcan.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hrms.karcan.entity.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
	List<Language> findFirst10ByNameContainingIgnoreCase(@Param("name") String name);
}
