package com.hina.hinagamesolution.game;

import java.util.Set;

import com.hina.hinagamesolution.domain.LandMine;

/**
 * Interface for MineGenerator
 * 
 * @author Hina
 *
 */
public interface MineGenerator {
	
	public static final int NONE = 1;
	public static final int RANDOM = 0;

	Set<LandMine> generateMines();
}
