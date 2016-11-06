package com.couchface.sports.basketballstats.entity;

public enum ShotType {

	DUNK("Dunk"),
	TIP_IN("Tip In"),
	LAYUP("Layup"),
	TWO_POINT_JUMPER("Two Point Jumper"),
	THREE_POINT_JUMPER("Three Point Jumper");
	private String value;
	
	private ShotType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}

}
