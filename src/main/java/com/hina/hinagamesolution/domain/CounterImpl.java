package com.hina.hinagamesolution.domain;

/**
 * CounterImpl
 * 
 * @author Hina
 *
 */
public class CounterImpl implements Counter{
	private BoardPosition position;
	private Orientation orientation;
	
	public CounterImpl(BoardPosition position, Orientation orientation) {
		this.position = position;
		this.orientation = orientation;
	}
	
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	public Orientation getOrientation() {
		return orientation;
	}
	
	
	public void setPosition(BoardPosition position) {
		this.position = position;
	}
	
	public BoardPosition getPosition() {
		return position;
	}
}
