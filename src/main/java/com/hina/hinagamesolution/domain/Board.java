package com.hina.hinagamesolution.domain;

/**
 * Interface Board.
 * 
 * @author hina
 *
 */
public interface Board {

	public static final int ALPHA_NUMERIC = 1;

	BoardPosition getStartPosition();

	int getTotalPositions();
	
	int getWidth();
	
	int getHeight();

	BoardPosition getPosition(int xPosition, int yPosition);

	BoardPosition shiftPosition(BoardPosition position, int xShift, int yShift);

	boolean isEndRow(BoardPosition currentPos);
}
