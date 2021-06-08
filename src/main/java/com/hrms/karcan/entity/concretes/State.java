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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "states")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class State extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "state_id")
	private int id;
	
	@NotNull(message = ValidationMessages.NOT_BLANK)
	@Column(name = "country_id")
	private int countryId;
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "name")
	private String name;
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "code")
	private String code;

	
	//relations mapping.
	@ManyToOne(targetEntity = Country.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "country_id" , insertable = false, updatable = false)
	private Country country;
	
}
