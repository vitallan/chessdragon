package com.allan;

import org.fusesource.jansi.AnsiConsole;

import com.allan.exception.IllegalMoveException;
import com.allan.game.Game;
import com.allan.player.Player;
import com.allan.player.PlayerZero;

public class App 
{
    public static void main( String[] args ) throws IllegalMoveException {
    	AnsiConsole.systemInstall();
    	Player[] array = new Player[2];
    	array[0] = new PlayerZero();
    	array[1] = new PlayerZero();
        Game game = new Game(array[0], array[1]);
        int i = 2;
        game.getBoard().printBoard();
        while(i < 10) {
        	game.getBoard().move(array[i%2].move());
        	game.checkWarnings();
        	System.out.println("\n\n");
        	game.getBoard().printBoard();
        	i++;
        }
        AnsiConsole.systemUninstall();
    }
}
