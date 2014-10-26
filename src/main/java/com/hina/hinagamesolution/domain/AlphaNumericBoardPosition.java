package com.hina.hinagamesolution.domain;

/**
 * Class that stores the location of a point on a AlphaNumericBoard.
 * Made up of the real x and y grid location (starting from 0) as well as the alpha-numeric position.
 * 
 * @author Hina
 *
 */
public class AlphaNumericBoardPosition implements BoardPosition{
	
	private char xPosition;
	private int yPosition;
	private int xGridPosition;
	private int yGridPosition;
	
	/**
	 * Construct the AlphaNumericBoardPosition
	 * 
	 * @param xGridPosition
	 * @param yGridPosition
	 * @param xPosition
	 * @param yPosition
	 */
	public AlphaNumericBoardPosition(int xGridPosition, int yGridPosition, char xPosition, int yPosition) {
		this.xGridPosition = xGridPosition;
		this.yGridPosition = yGridPosition;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	public String getPosition() {
		return xPosition + "" + yPosition;
	}
	
	public int getXGridPosition() {
		return xGridPosition;
	}

	public int getYGridPosition() {
		return yGridPosition;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AlphaNumericBoardPosition) {
			if (this.getPosition().equals(((AlphaNumericBoardPosition) obj).getPosition())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getPosition().hashCode(); 
	}
}
