package com.couchface.sports.basketballstats.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
public class Team {

	@Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
	private Long id;
	
	@Column(name = "SCHOOL_NM")
	private String schoolName;
	
	@Column(name = "MASCOT_TXT")
	private String mascot;
	
	@Column(name = "SEASON_TXT")
	private String season;
	
	@OneToMany( mappedBy = "team", cascade = CascadeType.ALL)
	private List<Player> players;

	public Team() {
		this.schoolName = "";
		this.mascot = "";
		this.season = "";
	}
	
	public Team shallowCopy() {
		Team copy = new Team();
		copy.setSchoolName(this.getSchoolName());
		copy.setMascot(this.getMascot());
		copy.setSeason(this.getSeason());
		copy.setId(this.getId());
		copy.getPlayers().addAll(this.getPlayers());
		return copy;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getMascot() {
		return mascot;
	}

	public void setMascot(String mascot) {
		this.mascot = mascot;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}
	
	public List<Player> getPlayers() {
		if (this.players == null) {
			this.players = new ArrayList<Player>();
		}
		return this.players;
	}
	
	public boolean equals(Team team) {
		if ((this.schoolName.equals(team.getSchoolName())) && (this.mascot.equals(team.getMascot())) && (this.season.equals(team.getSeason()))){
			return true;
		}
		return false;
	}
	
}
