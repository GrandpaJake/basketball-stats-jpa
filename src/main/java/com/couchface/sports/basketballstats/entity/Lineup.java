package com.couchface.sports.basketballstats.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LINEUP")
public class Lineup {
	
	@Id
    @GeneratedValue
    @Column(name = "LINEUP_ID")
	private Long id;

	@Column(name = "PERIOD")
	private int period;
	
	@Column(name = "START_TIME")
	private int startTime;
	
	@Column(name = "END_TIME")
	private int endTime;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="GAME_ID")
	private Game game;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "LINEUP_PLAYER", joinColumns = {
			@JoinColumn(name = "LINEUP_ID", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "PLAYER_ID",
					nullable = false, updatable = false) })
	private List<Player> players;
	
	public Lineup() {
		
	}
	
	public Lineup(Game game) {
		this.game = game;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	public List<Player> getPlayers() {
		if (this.players ==  null) {
			this.players = new ArrayList<Player>();
		}
		return this.players;
	}
	
	public Game getGame() {
		return this.game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}

	public Lineup shallowCopy() {
		Lineup copy = new Lineup();
		copy.setId(this.getId());
		copy.setEndTime(this.getEndTime());
		copy.setPeriod(this.getPeriod());
		copy.setStartTime(this.getStartTime());
		copy.setGame(this.getGame());
		copy.getPlayers().addAll(this.getPlayers());
		return copy;
	}

}
