package com.couchface.sports.basketballstats.entity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "Assist")
public class Assist extends GameEvent{

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ASSISTED_FIELD_GOAL_ID")
	private FieldGoal fieldGoal;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="PASSER_ID")
	private Player passer;
	
	public FieldGoal getFieldGoal() {
		return fieldGoal;
	}
	public void setFieldGoal(FieldGoal fieldGoal) {
		this.fieldGoal = fieldGoal;
	}
	public Player getPasser() {
		return passer;
	}
	public void setPasser(Player passer) {
		this.passer = passer;
	}
	
}
