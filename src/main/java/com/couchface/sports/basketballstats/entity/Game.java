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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GAME")
public class Game {

	@Id
    @GeneratedValue
    @Column(name = "GAME_ID")
	private Long id;
	
	@Column(name = "NCAA_GAME_ID")
	private int gameId;
	
	@Column(name = "GAME_TIME")
	private String gameTime;
	
	@Column(name = "ARENA_NM")
	private String arena;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="HOME_TEAM_ID")
	private Team homeTeam;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="AWAY_TEAM_ID")
	private Team awayTeam;
	
	@Column(name = "OFFICIAL_ONE_NM")
	private String officialOne;
	
	@Column(name = "OFFICIAL_TWO_NM")
	private String officialTwo;
	
	@Column(name = "OFFICIAL_THREE_NM")
	private String officialThree;
	
	@OneToMany( mappedBy = "game", cascade = CascadeType.ALL)
	private List<GameEvent> events;
	 
	@OneToMany(cascade=CascadeType.ALL, mappedBy="game") 
	private List<Lineup> lineups;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGameTime() {
		return gameTime;
	}
	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}
	public String getArena() {
		return arena;
	}
	public void setArena(String arena) {
		this.arena = arena;
	}
	public Team getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	public Team getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
	public String getOfficialOne() {
		return officialOne;
	}
	public void setOfficialOne(String officialOne) {
		this.officialOne = officialOne;
	}
	public String getOfficialTwo() {
		return officialTwo;
	}
	public void setOfficialTwo(String officialTwo) {
		this.officialTwo = officialTwo;
	}
	public String getOfficialThree() {
		return officialThree;
	}
	public void setOfficialThree(String officialThree) {
		this.officialThree = officialThree;
	}
	public List<GameEvent> getEvents() {
		if (this.events ==  null) {
			this.events = new ArrayList<GameEvent>();
		}
		return this.events;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public List<Lineup> getLineups() {
		if (this.lineups ==  null) {
			this.lineups = new ArrayList<Lineup>();
		}
		return this.lineups;
	}
	
}
