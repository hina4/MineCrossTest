package com.hina.hinagamesolution.game;

import com.hina.hinagamesolution.domain.Board;

/**
 * Factory class to generate board games.
 * 
 * @author Hina
 *
 */
public class BoardGameFactory {
	
	private static final int MAX_ALLOWED_HITS = 3;
	private static final int WIDTH = 8;
	private static final int HEIGHT = 8;
	
	public static BoardGame createGame(int gameType) {
		
        switch (gameType) {
            case BoardGame.MINE_CROSS_BOARD_GAME: default:  return new MineCrossBoardGameBuilder().withAllowedHits(MAX_ALLOWED_HITS).
    				withBoardType(Board.ALPHA_NUMERIC).withGenerateMineMethod(MineGenerator.RANDOM).
    				withSize(WIDTH, HEIGHT).buildGame();
        }
    }
}
