package com.hina.hinagamesolution.domain;


/**
 * LandMine class storing the location on the board and whether is has been hit.
 * 
 * @author Hina
 *
 */
public class LandMine {

	private boolean hit;
	
	private BoardPosition position;
	
	public LandMine(BoardPosition position) {
		this.position = position;
		hit = false;
	}
	
	public BoardPosition getPosition() {
		return position;
	}
	
	public void setHit() {
		hit = true;
	}
	
	public boolean getHit() {
		return hit;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LandMine) {
			if (((LandMine)obj).getPosition().equals(this.getPosition()) && ((LandMine)obj).getHit() == this.getHit()) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
        return this.getPosition().hashCode() + (this.getHit() ? 0 : 1);
    }
}
