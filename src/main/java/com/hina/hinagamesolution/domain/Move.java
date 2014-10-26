package com.hina.hinagamesolution.domain;

public enum Move {
	
	M ("forward"),
	RAC ("rotate-anticlockwise"),
	RC ("rotate-clockwise");
	
	private String moveAction;
	
	private Move (String moveAction) {
		this.moveAction = moveAction;
	}
	
	public String getMoveAction() {
		return moveAction;
	}
	
}
