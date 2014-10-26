package com.hina.hinagamesolution.domain;

/**
 * Interface Counter
 * 
 * @author Hina
 *
 */
public interface Counter {
	
	void setOrientation(Orientation orientation);
	
	Orientation getOrientation();
	
	void setPosition(BoardPosition position);
	
	BoardPosition getPosition();
}
