package com.couchface.sports.basketballstats.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "FreeThrow")
public class FreeThrow extends GameEvent {

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="SHOOTING_PLAYER_ID")
	private Player shooter;
	
	@Column( name = "MADE_FLG")
	private Integer made;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="FOUL_ID")
	private Foul foul;
	
	public Player getShooter() {
		return shooter;
	}
	public void setShooter(Player shooter) {
		this.shooter = shooter;
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
	public Foul getFoul() {
		return foul;
	}
	public void setFoul(Foul foul) {
		this.foul = foul;
	}
	
}
