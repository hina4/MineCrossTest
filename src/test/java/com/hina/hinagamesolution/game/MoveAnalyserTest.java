package com.hina.hinagamesolution.game;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hina.hinagamesolution.domain.AlphaNumericBoard;
import com.hina.hinagamesolution.domain.AlphaNumericBoardPosition;
import com.hina.hinagamesolution.domain.Board;
import com.hina.hinagamesolution.domain.Counter;
import com.hina.hinagamesolution.domain.CounterImpl;
import com.hina.hinagamesolution.domain.Orientation;

public class MoveAnalyserTest {

	@Test
	public void testPlayMoveSuccess() {
		Counter counter = new CounterImpl(new AlphaNumericBoardPosition(4,1,'E',2),Orientation.EAST);
		Board board = new AlphaNumericBoard(8,8);
		MoveAnalyser mover = new MoveAnalyser(board, counter);
		boolean moved = mover.playMove("RACM3");
		assertTrue(moved);
		assertEquals("E5", counter.getPosition().getPosition());
		assertEquals(Orientation.NORTH, counter.getOrientation());
	}
	
	@Test
	public void testPlayMoveFail() {
		Counter counter = new CounterImpl(new AlphaNumericBoardPosition(4,1,'E',2),Orientation.EAST);
		Board board = new AlphaNumericBoard(8,8);
		MoveAnalyser mover = new MoveAnalyser(board, counter);
		boolean moved = mover.playMove("RCM3");
		assertFalse(moved);
	}

}
