package com.couchface.sports.basketballstats.entity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "Steal")
public class Steal extends GameEvent {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="TURNOVER_ID")
	private Turnover turnover;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="STEALING_PLAYER_ID")
	private Player player;
	
	public Turnover getTurnover() {
		return turnover;
	}
	public void setTurnover(Turnover turnover) {
		this.turnover = turnover;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
