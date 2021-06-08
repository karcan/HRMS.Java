package com.hrms.karcan.entity.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.hrms.karcan.business.constants.ValidationMessages;
import com.hrms.karcan.core.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "countries")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Country extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private int id;
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "name")
	private String name;
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "iso")
	private String iso;
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "phone_code")
	private String phoneCode;
	
	@NotBlank(message = ValidationMessages.NOT_BLANK)
	@Column(name = "currency_code")
	private String currencyCode;
}
