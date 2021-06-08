package com.hrms.karcan.entity.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSummaryDto {
	private int id;
	private String companyName;
	private String jobTitle;
	private BigDecimal applicantQuota;
	private Instant createdDate;
	private Date lastApplicationDate; 
}
