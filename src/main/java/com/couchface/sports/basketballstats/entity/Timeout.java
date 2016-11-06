package com.couchface.sports.basketballstats.entity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "Timeout")
public class Timeout extends GameEvent {
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="TIMEOUT_TYP_CD")
	private TimeoutTypeDomain type;

	public TimeoutTypeDomain getType() {
		return type;
	}

	public void setType(TimeoutTypeDomain type) {
		this.type = type;
	}
	
}
