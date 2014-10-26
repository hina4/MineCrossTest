package com.hina.hinagamesolution.game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.hina.hinagamesolution.domain.Board;
import com.hina.hinagamesolution.game.MineCrossBoardGame;
import com.hina.hinagamesolution.game.MineCrossBoardGameBuilder;
import com.hina.hinagamesolution.game.MineGenerator;

public class MineCrossBoardGameTest {
	
	private static final int WIDTH = 8;
	private static final int HEIGHT = 8;
	private static final int MAX_HITS = 3;
	
	private MineCrossBoardGame game = null;
	
	@Before
	public void setUpGame() {
		game = new MineCrossBoardGameBuilder().withAllowedHits(MAX_HITS).
				withBoardType(Board.ALPHA_NUMERIC).withGenerateMineMethod(MineGenerator.NONE).
				withSize(WIDTH, HEIGHT).buildGame();
	}

	@Test
	public void TestSuccessGame() {
		String result = game.playMove("M2");
		assertEquals("Unexpected game result.", "LOCATION:A3 FACING:NORTH MINES_HIT:0 RESULT:NONE", result);
		result = game.playMove("RCM5");
		assertEquals("Unexpected game result.", "LOCATION:F3 FACING:EAST MINES_HIT:0 RESULT:NONE", result);
		result = game.playMove("RACM5");
		assertEquals("Unexpected game result.", "LOCATION:F8 FACING:NORTH MINES_HIT:0 RESULT:WON", result);
	}
	
	@Test
	public void TestBadMove() {
		String result = game.playMove("RACM5");
		assertEquals(MineCrossBoardGame.NOT_ALLOWED, result);
	}
}
