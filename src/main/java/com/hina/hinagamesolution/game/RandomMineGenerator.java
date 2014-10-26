package com.hina.hinagamesolution.game;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.hina.hinagamesolution.domain.Board;
import com.hina.hinagamesolution.domain.BoardPosition;
import com.hina.hinagamesolution.domain.LandMine;

/**
 * Random MineGenerator class - generates a random number of mines and then creates them on random location
 * 
 * @author Hina
 *
 */
public class RandomMineGenerator implements MineGenerator{
	
	private Random random;
	
	private Board board;
	
	public RandomMineGenerator(Board board) {
		this.board = board;
		random = new Random();
	}

	public Set<LandMine> generateMines() {
		
		int totalSquares = board.getTotalPositions();
		
		int minesToGenerate = random.nextInt(totalSquares);

		return getMines(minesToGenerate);
	}
	
	private Set<LandMine> getMines(int minesToGenerate) {
		Set<LandMine> mines = new HashSet<LandMine>();
		Random random = new Random();
		for (int i=0; i<minesToGenerate; i++) {
			boolean addedMine = false;
			while (!addedMine) {
				int xPosition = random.nextInt(board.getWidth());
				int yPosition =  random.nextInt(board.getHeight());
				BoardPosition position = board.getPosition(xPosition, yPosition);
				LandMine mine = new LandMine(position);
				addedMine = mines.add(mine);
			}
		}
		return mines;
	}

}
