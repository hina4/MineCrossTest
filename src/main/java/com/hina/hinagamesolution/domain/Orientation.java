package com.hina.hinagamesolution.domain;

/**
 * Orientation enum, also storing the resulting orientation on clockwise or anticlockwise turn 90degrees.
 * 
 * @author Hina
 *
 */
public enum Orientation {
	NORTH ("EAST", "WEST"),
	EAST ("SOUTH", "NORTH"),
	SOUTH ("WEST", "EAST"),
	WEST ("NORTH", "SOUTH");
	
	private String turnClockWise;
	private String turnAntiClockWise;
	
	private Orientation(String turnClockWise, String turnAntiClockWise) {
		this.turnClockWise = turnClockWise;
		this.turnAntiClockWise = turnAntiClockWise;
	}
	
	public Orientation getClockWise() {
		return Orientation.valueOf(turnClockWise);
	}
	
	public Orientation getAntiClockWise() {
		return Orientation.valueOf(turnAntiClockWise);
	}
}
