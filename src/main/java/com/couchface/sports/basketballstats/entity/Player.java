package com.couchface.sports.basketballstats.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER")
public class Player {

	@Id
    @GeneratedValue
    @Column(name = "PLAYER_ID")
	private Long id;
	
	@Column(name = "FIRST_NM")
	private String firstName;
	
	@Column(name = "LAST_NM")
	private String lastName;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="TEAM_ID")
	private Team team;
	
	public Player() {
		
	}
	
	public Player(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	public String getUniqueName() {
		return (firstName+lastName+team.getSchoolName());
	}
	
}
