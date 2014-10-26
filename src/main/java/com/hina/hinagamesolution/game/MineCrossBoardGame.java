package com.hina.hinagamesolution.game;

import java.util.Collections;
import java.util.Set;

import com.hina.hinagamesolution.domain.AlphaNumericBoard;
import com.hina.hinagamesolution.domain.Board;
import com.hina.hinagamesolution.domain.BoardPosition;
import com.hina.hinagamesolution.domain.Counter;
import com.hina.hinagamesolution.domain.CounterImpl;
import com.hina.hinagamesolution.domain.GameResult;
import com.hina.hinagamesolution.domain.LandMine;
import com.hina.hinagamesolution.domain.Orientation;

/**
 * MineCrossBoardGame where the user moves from the starting position to get to the end point 
 * without hitting more than the allowed number of mines (which are generated randomly). 
 * 
 * @author Hina
 *
 */
public class MineCrossBoardGame implements BoardGame {
	
	private static final Orientation START_FACING = Orientation.valueOf("NORTH");
	public static final String NOT_ALLOWED = "Move provided is not allowed.  Please try again";
	private static final String PROMPT_FOR_MOVE = "Please enter your move";
	private static final String FINISHED = "Game has finished, please start another";
	
	private int width;
	private int height;
	private Set<LandMine> mines;
	private GameResult gameResult = GameResult.NONE;
	private int maxAllowedHits;
	private MoveAnalyser mover;
	private Board board;
	private Counter counter;
	
	/**
	 * Constructor for MineCrossBoardGame
	 * 
	 * @param width width of Board
	 * @param height height of Board
	 * @param boardType the BoardType.
	 * @param allowedHits max mines hit to lose game
	 * @param generateMineMethod the method to generate the mines (random, none)
	 */
	public MineCrossBoardGame(int width, int height, int boardType, int allowedHits, int generateMineMethod) {
		this.width = width;
		this.height = height;
		this.maxAllowedHits = allowedHits;
		setUpBoard(boardType);
		setUpMover();
		generateLandMines(generateMineMethod);
	}
	
	/* (non-Javadoc)
	 * @see com.hina.hinagamesolution.game.BoardGame#gameFinished()
	 */
	public boolean gameFinished() {
		return gameResult == GameResult.LOST || gameResult == GameResult.WON;
	}
	
	/* (non-Javadoc)
	 * @see com.hina.hinagamesolution.game.BoardGame#getPrompt()
	 */
	public String getPrompt() {
		if (!gameFinished()) {
			return PROMPT_FOR_MOVE;
		}
		else {
			return FINISHED;
		}
	}

	/**
	 * Setup the board for the given type.
	 * @param boardType
	 */
	private void setUpBoard(int boardType) {
		if (boardType == Board.ALPHA_NUMERIC) {
			board = new AlphaNumericBoard(width, height);
		}
		
	}

	/**
	 * Set up the MoveAnalyser
	 */
	private void setUpMover() {
		counter = new CounterImpl(board.getStartPosition(), START_FACING);
		mover = new MoveAnalyser(board, counter);
	}

	/* (non-Javadoc)
	 * @see com.hina.hinagamesolution.game.BoardGame#playMove(java.lang.String)
	 */
	public String playMove(String moveString) {
		if (!mover.playMove(moveString)) {
			return NOT_ALLOWED;
		}
		
		BoardPosition currentPos = counter.getPosition();
		for (LandMine mine : mines) {
			if (!mine.getHit() && mine.getPosition().equals(currentPos)) {
				mine.setHit();
				break;
			}
		}
		if (getHitMines() == maxAllowedHits) {
			gameResult = GameResult.LOST;
		}
		else if (board.isEndRow(currentPos)) {
			gameResult = GameResult.WON;
		}
		return generateMoveResult();
	}
	
	/**
	 * Generate the landmines according to method selected.
	 * @param generateMineMethod
	 */
	private void generateLandMines(int generateMineMethod) {
		if (generateMineMethod == MineGenerator.RANDOM) {
			MineGenerator mineGenerator = new RandomMineGenerator(board);
			mines = mineGenerator.generateMines();
		}
		else if (generateMineMethod == MineGenerator.NONE) {
			mines = Collections.emptySet();
		}
	}
	
	/**
	 * Get the result from the move: location, orientation, mines hit and current status of game (none,won,lost)
	 * @return result String
	 */
	private String generateMoveResult() {
		StringBuffer sb = new StringBuffer();
		sb.append("LOCATION:" + counter.getPosition().getPosition() + " FACING:" 
				+ counter.getOrientation() + " MINES_HIT:" + getHitMines() + " RESULT:" + gameResult);
		return sb.toString();
		
	}

	/**
	 * Get the number of mines hit so far
	 * @return int
	 */
	private int getHitMines() {
		int totalHit = 0;
		for (LandMine mine: mines) {
			if (mine.getHit()) {
				totalHit++;
			}
		}
		
		return totalHit;
	}
}
