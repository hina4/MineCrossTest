package com.hina.hinagamesolution.domain;

/**
 * A board that is made of letters horizontally and numbers vertically, like a chess board.
 * 
 * @author Hina
 *
 */
public class AlphaNumericBoard implements Board{
	
	private char [] horizontal;
	private int [] vertical;
	private int width;
	private int height;
	
	/**
	 * Construct a new AlphaNumericBoard for the width and height provided.
	 * @param width
	 * @param height
	 */
	public AlphaNumericBoard(int width, int height) {
		this.width = width;
		this.height = height;
		initialiseBoard();
	}
	
	/**
	 * Set up the horizontal and vertical axis values.
	 */
	private void initialiseBoard() {
		horizontal = new char[width];
		vertical = new int[height];
		for (int i=0; i<horizontal.length; i++) {
			horizontal[i] = (char)(i+65);
		}
		for (int i=0; i<vertical.length; i++) {
			vertical[i] = i+1;
		}
	}

	/* (non-Javadoc)
	 * @see com.hina.hinagamesolution.domain.Board#getStartPosition()
	 */
	public BoardPosition getStartPosition() {
		return new AlphaNumericBoardPosition(0, 0, horizontal[0], vertical[0]);
	}
	
	/* (non-Javadoc)
	 * @see com.hina.hinagamesolution.domain.Board#getPosition(int, int)
	 */
	public BoardPosition getPosition(int xPosition, int yPosition) {
		return new AlphaNumericBoardPosition(xPosition, yPosition, horizontal[xPosition], vertical[yPosition]);
	}

	/* (non-Javadoc)
	 * @see com.hina.hinagamesolution.domain.Board#getTotalPositions()
	 */
	public int getTotalPositions() {
		return horizontal.length * vertical.length;
	}
	
	/* (non-Javadoc)
	 * @see com.hina.hinagamesolution.domain.Board#getWidth()
	 */
	public int getWidth() {
		return width;
	}
	
	/* (non-Javadoc)
	 * @see com.hina.hinagamesolution.domain.Board#getHeight()
	 */
	public int getHeight() {
		return height;
	}

	/* (non-Javadoc)
	 * @see com.hina.hinagamesolution.domain.Board#shiftPosition(com.hina.hinagamesolution.domain.BoardPosition, int, int)
	 */
	public BoardPosition shiftPosition(BoardPosition position, int xShift,
			int yShift) {
		int newX = position.getXGridPosition() + xShift;
		int newY = position.getYGridPosition() + yShift;
		if (newX>=0 && newX<width && newY>=0 && newY <height) {
			return getPosition(newX, newY);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hina.hinagamesolution.domain.Board#isEndRow(com.hina.hinagamesolution.domain.BoardPosition)
	 */
	public boolean isEndRow(BoardPosition currentPos) {
		return currentPos.getYGridPosition()+1 == height;
	}

}
