package com.couchface.sports.basketballstats.entity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "Block")
public class Block extends GameEvent {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="BLOCKED_FIELD_GOAL_ATTEMPT_ID")
	private FieldGoal fieldGoalAttempt;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="BLOCKING_PLAYER_ID")
	private Player blocker;
	
	public FieldGoal getFieldGoalAttempt() {
		return fieldGoalAttempt;
	}
	public void setFieldGoalAttempt(FieldGoal fieldGoalAttempt) {
		this.fieldGoalAttempt = fieldGoalAttempt;
	}
	public Player getBlocker() {
		return blocker;
	}
	public void setBlocker(Player blocker) {
		this.blocker = blocker;
	}
	
}
