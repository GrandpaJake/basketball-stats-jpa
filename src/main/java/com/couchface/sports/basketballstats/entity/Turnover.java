package com.couchface.sports.basketballstats.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "Turnover")
public class Turnover extends GameEvent {
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="TO_PLAYER_ID")
	private Player player;
	
	@Column( name = "TEAM_FLG")
	private Integer teamTurnover = 0;
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public boolean isTeamTurnover() {
		return (teamTurnover == 1);
	}
	public void setTeamTurnover(boolean teamTurnover) {
		if (teamTurnover) {
			this.teamTurnover = 1;
		} else {
			this.teamTurnover = 0;
		}
	}
	
}
