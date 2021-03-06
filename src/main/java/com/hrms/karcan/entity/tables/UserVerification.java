package com.hrms.karcan.entity.tables;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.core.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_verifications")
@AllArgsConstructor
@NoArgsConstructor
public class UserVerification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_verification_id")
	private int id;
	
	@CreatedDate
	@JsonIgnore
    @Column(name = "created_date", updatable = false)
    private Instant createdDate = Instant.now();
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "user_id")
	private int userId;
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "code")
	private String code;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "expiry_date")
	private Instant expiryDate;
	
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "verification_date")
	private Instant verificationDate;
	
	//relation mapping
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user; 
	
}
