package com.hina.hinagamesolution.game;

import com.hina.hinagamesolution.domain.Board;
import com.hina.hinagamesolution.domain.BoardPosition;
import com.hina.hinagamesolution.domain.Counter;
import com.hina.hinagamesolution.domain.Move;
import com.hina.hinagamesolution.domain.Orientation;

/**
 * A class that determines whether a given move can be carried out before carrying it out.
 * 
 * @author Hina
 *
 */
public class MoveAnalyser {
	
	private Board board;
	private Counter counter;

	public MoveAnalyser(Board board, Counter counter) {
		this.board = board;
		this.counter = counter;
	}
	
	/**
	 * TODO only use moves from a set of allowed moves. Return otherwise with info.
	 * 
	 * @param move
	 * @return
	 */
	public boolean playMove(String move) {
		Orientation currentOrientation = counter.getOrientation();
		boolean canMove = false;
		if (move.startsWith(Move.RC.toString())) {
			counter.setOrientation(currentOrientation.getClockWise());
			move = move.substring(2);
		} 
		else if (move.startsWith(Move.RAC.toString())) {
			counter.setOrientation(currentOrientation.getAntiClockWise());
			move = move.substring(3);
		}
		if (move.startsWith(Move.M.toString())) {
			int moveForwardNum = Integer.parseInt(move.substring(1));
			canMove = moveCounterForward(moveForwardNum);
		} 
		else {
			//Handle input move error
		}
		
		if (!canMove) {
			counter.setOrientation(currentOrientation);
			//log some error to say the move was not possible.
		}
		return canMove;
	}

	private boolean moveCounterForward(int moveForwardNum) {
		int moveX = 0;
		int moveY = 0;
		Orientation orientation = counter.getOrientation();
		if (orientation == Orientation.NORTH) {
			moveY = moveForwardNum;
		}
		else if (orientation == Orientation.EAST) {
			moveX = moveForwardNum;
		}
		else if (orientation == Orientation.SOUTH) {
			moveY = -moveForwardNum;
		}
		else {
			moveX = -moveForwardNum;
		}

		BoardPosition newPosition = board.shiftPosition(counter.getPosition(), moveX, moveY);
		counter.setPosition(newPosition);
		
		return newPosition != null ? true : false;
	}

}
