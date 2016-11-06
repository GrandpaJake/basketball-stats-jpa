package com.couchface.sports.basketballstats.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "Foul")
public class Foul extends GameEvent {

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="FOULING_PLAYER_ID")
	private Player fouler;
	
	@Column(name = "TEAM_FLG")
	private Integer teamFoul = 0;
	
	@Column(name = "COACH_FOUL_FLG")
	private Integer coachFoul = 0;
	
	public Player getFouler() {
		return fouler;
	}
	public void setFouler(Player fouler) {
		this.fouler = fouler;
	}
	public boolean isTeamFoul() {
		return (teamFoul == 1);
	}
	public void setTeamFoul(boolean teamFoul) {
		if (teamFoul) {
			this.teamFoul = 1;
		} else {
			this.teamFoul = 0;
		}
	}
	public boolean isCoachFoul() {
		return (coachFoul == 1);
	}
	public void setCoachFoul(boolean coachFoul) {
		if (coachFoul) {
			this.coachFoul = 1;
		} else {
			this.coachFoul = 0;
		}
	}
	
}
