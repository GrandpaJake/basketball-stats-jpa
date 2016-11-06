package com.couchface.sports.basketballstats.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIMEOUT_TYPE_DM")
public class TimeoutTypeDomain {

	@Id
    @GeneratedValue
    @Column(name = "TIMEOUT_TYP_CD")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TimeoutType timeoutType;

	public TimeoutTypeDomain(TimeoutType type) {
		this.timeoutType = type;
	}

	public TimeoutType getTimeoutType() {
		return timeoutType;
	}

	public void setTimeoutType(TimeoutType timeoutType) {
		this.timeoutType = timeoutType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
