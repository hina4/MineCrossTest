package com.hina.hinagamesolution.game;

/**
 * BoardGame interface
 * 
 * @author Hina
 *
 */
public interface BoardGame {
	
	public static final int MINE_CROSS_BOARD_GAME = 1;

	String playMove(String move);
	
	boolean gameFinished();
	
	String getPrompt();

}
