package com.couchface.sports.basketballstats.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SHOT_TYPE_DM")
public class ShotTypeDomain {

	@Id
    @GeneratedValue
    @Column(name = "SHOT_TYP_CD")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private ShotType shotType;

	public ShotTypeDomain(ShotType type) {
		this.shotType = type;
	}

	public ShotType getShotType() {
		return shotType;
	}

	public void setShotType(ShotType shotType) {
		this.shotType = shotType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
