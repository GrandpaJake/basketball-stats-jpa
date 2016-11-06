package com.couchface.sports.basketballstats.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "Rebound")
public class Rebound extends GameEvent {

	public static final String OFFENSIVE = "O";
	public static final String DEFENSIVE = "D";
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="REBOUNDING_PLAYER_ID")
	private Player rebounder;
	
	@Column( name = "TEAM_REB_FLG")
	private Integer teamRebound = 0;
	
	@Column( name = "REB_TYP")
	private String type;
	
	public Player getRebounder() {
		return rebounder;
	}
	public void setRebounder(Player rebounder) {
		this.rebounder = rebounder;
	}
	public boolean isTeamRebound() {
		return (teamRebound == 1);
	}
	public void setTeamRebound(boolean teamRebound) {
		if (teamRebound) {
			this.teamRebound = 1;
		} else {
			this.teamRebound = 0;
		}
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
