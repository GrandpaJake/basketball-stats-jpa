package com.couchface.sports.basketballstats.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GAME_EVENT")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="EVENT_TYPE",
    discriminatorType=DiscriminatorType.STRING)
public abstract class GameEvent {

	@Id
    @GeneratedValue
    @Column(name = "EVENT_ID")
	protected Long id;
	
	@Column(name = "TIME")
	protected int time;
	
	@Column(name = "PERIOD")
	protected int period;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="TEAM_ID")
	protected Team team;
	
	@Column(name = "EVENT_TXT")
	protected String eventText;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="GAME_ID")
	protected Game game;
	
	@JoinColumn(name="HOME_LINEUP_ID")
	protected Lineup homeLineup;
	
	@JoinColumn(name="AWAY_LINEUP_ID")
	protected Lineup awayLineup;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getEventText() {
		return eventText;
	}

	public void setEventText(String eventText) {
		this.eventText = eventText;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public Lineup getHomeLineup() {
		return homeLineup;
	}

	public void setHomeLineup(Lineup homeLineup) {
		this.homeLineup = homeLineup;
	}
	
	public Lineup getAwayLineup() {
		return awayLineup;
	}

	public void setAwayLineup(Lineup awayLineup) {
		this.awayLineup = awayLineup;
	}
	
	public abstract void replaceFieldsWithPersistedObjects(Game persistedGame, List<ShotTypeDomain> shotTypes, List<TimeoutTypeDomain> timeoutTypes);
	
}