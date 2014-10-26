package com.hina.hinagamesolution.game;

/**
 * Builder for MineCrossBoardGame
 * 
 * @author hina
 *
 */
public class MineCrossBoardGameBuilder {
	
	private int width;
	private int height;
	private int allowedHits;
	private int mineMethod;
	private int boardType;
	
	public MineCrossBoardGameBuilder() {
	}
	
	public MineCrossBoardGameBuilder withSize(int width, int height) {
		this.width = width;
		this.height = height;
		return this;
	}
	
	public MineCrossBoardGameBuilder withBoardType(int boardType) {
		this.boardType = boardType;
		return this;
	}
	
	public MineCrossBoardGameBuilder withAllowedHits(int allowedHits) {
		this.allowedHits = allowedHits;
		return this;
	}
	
	
	public MineCrossBoardGameBuilder withGenerateMineMethod(int mineMethod) {
		this.mineMethod = mineMethod;
		return this;
	}
	
	public MineCrossBoardGame buildGame() {
		return new MineCrossBoardGame(width, height, boardType, allowedHits, mineMethod);
	}

}
