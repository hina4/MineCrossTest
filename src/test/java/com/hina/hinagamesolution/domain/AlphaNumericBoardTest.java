package com.hina.hinagamesolution.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlphaNumericBoardTest {

	private static final int WIDTH = 8;
	private static final int HEIGHT = 8;

	/**
	 * Test the shiftPosition method
	 */
	@Test
	public void testShiftPosition() {
		AlphaNumericBoard board = new AlphaNumericBoard(WIDTH, HEIGHT);
		BoardPosition position = new AlphaNumericBoardPosition(0,0, 'A', 1);
		
		BoardPosition newPosition = board.shiftPosition(position, 4, 5);
		
		assertEquals("New position is not correct", "E6", newPosition.getPosition());
	}

}
