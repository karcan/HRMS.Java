package com.hrms.karcan.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hrms.karcan.entity.concretes.Job;
import com.hrms.karcan.entity.dtos.JobSummaryDto;



public interface JobRepository extends JpaRepository<Job, Integer> {
		
	@Query(Query_JobSummaryDto)
	List<JobSummaryDto> getAllJobSummaryDto();
	
	@Query(Query_JobSummaryDto)
	List<JobSummaryDto> getAllJobSummaryDto(Sort sort);
	
	@Query(Query_JobSummaryDtoByCompanyName)
	List<JobSummaryDto> getAllJobSummaryDtoByCompanyName(@Param("companyName") String companyName);
	
	@Query(Query_JobSummaryDtoByJobTitle)
	List<JobSummaryDto> getAllJobSummaryDtoByJobTitle(@Param("jobTitle") String jobTitle);
	
	
	String Query_JobSummaryDto = "SELECT new com.hrms.karcan.entity.dtos.JobSummaryDto "
			+ 	"(j.id as id, "
			+ 	"u.companyName as companyName, "
			+ 	"jt.title as jobTitle, "
			+	"j.applicantQuota as applicantQuota, "
			+ 	"j.createdDate as createdDate, "
			+	"j.lastApplicationDate as lastApplicationDate)"
			
			+ 	"FROM Job j "
			+ 	"JOIN j.jobTitle jt "
			+ 	"JOIN j.createdUser u "
			+ 	"WHERE j.active = true "
			+ 	"AND j.lastApplicationDate >= CURRENT_DATE ";
	
	String Query_JobSummaryDtoByCompanyName = Query_JobSummaryDto
			+ 	"AND lower(u.companyName) like CONCAT('%',lower(:companyName),'%')"; 
	
	String Query_JobSummaryDtoByJobTitle = Query_JobSummaryDto
			+ 	"AND lower(jt.title) like CONCAT('%',lower(:jobTitle),'%')"; 
}
