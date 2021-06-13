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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.core.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_confirms")
@AllArgsConstructor
@NoArgsConstructor
public class UserConfirm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_confirm_id")
	private int id;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "user_id")
	private int userId;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "is_confirmed")
	private boolean confirmed;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "confirmed_user_id")
	private int confirmedUserId;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "confirmed_date")
	private Instant confirmedDate;
	
	//relation mapping
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user; 
	
	@ManyToOne(targetEntity = Employee.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "confirmed_user_id", insertable = false, updatable = false)
	private Employee confirmedUser; 
}
