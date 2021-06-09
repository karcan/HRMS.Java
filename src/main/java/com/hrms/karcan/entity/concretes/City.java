package com.hrms.karcan.entity.concretes;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.core.entity.BaseEntity;
import com.hrms.karcan.core.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class City extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int id;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "state_id")
	private int stateId;
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "name")
	private String name;
	

	//relation mapping.
	@ManyToOne(targetEntity = State.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "state_id" , insertable = false, updatable = false)
	private State country;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "created_user_id", insertable = false, updatable = false)
	private User createdUser; 
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "modified_user_id", insertable = false, updatable = false)
	private User modifiedUser; 
}
