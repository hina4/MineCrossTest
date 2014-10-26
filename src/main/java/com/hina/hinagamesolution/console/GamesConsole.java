package com.hina.hinagamesolution.console;

import java.io.PrintStream;
import java.util.Scanner;

import com.hina.hinagamesolution.game.BoardGame;
import com.hina.hinagamesolution.game.BoardGameFactory;

/**
 * Games console that allows the user to select the game to play and then
 * play the game until won or lost.
 * 
 * 
 * @author Hina
 *
 */
public class GamesConsole {

	private static final String GAME_OPTIONS = "Welcome to the Game console!\n" +
            "Please select a game type from the following options:\n" +
            "1. Mine Cross Board Game\n";
	private static final String FINISHED = "FINISHED.";

    /**
     * Play a game from a command line interface.
     * @param args 
     */
    public static void main(String[] args) {
        runGame();
    }

    /**
     * Select and play the game.
     */
    private static void runGame() {
        Scanner scanner = new Scanner(System.in);
        PrintStream outStream = System.out;

        outStream.println(GAME_OPTIONS);
        int gameType = scanner.nextInt();
        
        System.out.println(gameType);

        BoardGame game = BoardGameFactory.createGame(gameType);
        while (!game.gameFinished()) {
        	outStream.println(game.getPrompt());
        	String move = scanner.next();
        	outStream.println(game.playMove(move));
        }
        outStream.println(FINISHED);
        scanner.close();
    }
}
