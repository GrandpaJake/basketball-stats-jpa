package com.couchface.sports.basketballstats.entity;

public enum TimeoutType {

	FULL("Timeout"),
	THIRTY_SEC("30 Second Timeout"),
	MEDIA("Media");
	private String value;
	
	private TimeoutType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
