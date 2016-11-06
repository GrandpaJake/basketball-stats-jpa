package com.couchface.sports.basketballstats.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "FieldGoal")
public class FieldGoal extends GameEvent {

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="SHOOTING_PLAYER_ID")
	private Player shooter;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="SHOT_TYP_CD")
	private ShotTypeDomain type;
	
	@Column(name = "MADE_FLG")
	private Integer made;
	
	public Player getShooter() {
		return shooter;
	}
	public void setShooter(Player shooter) {
		this.shooter = shooter;
	}
	public ShotTypeDomain getType() {
		return type;
	}
	public void setType(ShotTypeDomain type) {
		this.type = type;
	}
	public boolean isMade() {
		return (made == 1);
	}
	public void setMade(boolean made) {
		if (made) {
			this.made = 1;
		} else {
			this.made = 0;
		}
	}
	
}
