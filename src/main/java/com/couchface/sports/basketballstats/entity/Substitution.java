package com.couchface.sports.basketballstats.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "Substitution")
public class Substitution extends GameEvent {

	public static final String enter = "ENTER";
	public static final String exit = "EXIT";
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="SUB_PLAYER_ID")
	private Player player;
	
	@Column( name = "ENTER_FLG")
	private String enterFlag;
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getEnterFlag() {
		return enterFlag;
	}
	public void setEnterFlag(String enterFlag) {
		this.enterFlag = enterFlag;
	}
	public static String getEnter() {
		return enter;
	}
	public static String getExit() {
		return exit;
	}
}
