package com.hrms.karcan.core.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
	
	@CreatedDate
    @JsonIgnore
    @Column(name = "created_date", updatable = false)
    private Instant createdDate = Instant.now();
	
	@JsonIgnore
	@Column(name = "created_user_id")
	private int createdUserId = 1;

    @LastModifiedDate
    @JsonIgnore
    @Column(name = "modified_date")
    private Instant modifiedDate = Instant.now();
    
    @JsonIgnore
    @Column(name = "modified_user_id")
    private int modifiedUserId = 1;
    
    @JsonIgnore
    @Column(name = "is_deleted")
    private boolean deleted = false;
    
    @JsonIgnore
    @Column(name = "is_active")
    private boolean active = true;
}
