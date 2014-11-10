package com.allan;

import java.util.List;

import org.fusesource.jansi.AnsiConsole;

import com.allan.game.Game;
import com.allan.game.Piece;
import com.allan.piece.Bishop;
import com.allan.piece.King;
import com.allan.piece.Knight;
import com.allan.piece.Queen;
import com.allan.piece.Rook;
import com.allan.player.Player;
import com.allan.player.PlayerZero;
import com.allan.set.Position;

public class App 
{
    public static void main( String[] args ) {
    	AnsiConsole.systemInstall();
    	Player[] array = new Player[2];
    	array[0] = new PlayerZero();
    	array[1] = new PlayerZero();
        Game game = new Game(array[0], array[1]);
        int i = 2;
        while(!game.isFinished()) {
        	array[i%2].move();
        	game.checkWarnings();
        	i++;
        }
        game.getBoard().printBoard();
        Piece[][] boardSnapshot = game.getBoard().getBoardSnapshot();
        Rook rook = array[0].getSet().rook_1;
        Queen queen = array[0].getSet().queen;
        Bishop bishop = array[0].getSet().bishop_1;
        King king = array[0].getSet().king;
        Knight knight = array[0].getSet().knight_1;
        List<Position> pos = rook.getPossibleMoves(boardSnapshot);
        pos = queen.getPossibleMoves(boardSnapshot);
        pos = bishop.getPossibleMoves(boardSnapshot);
        pos = king.getPossibleMoves(boardSnapshot);
        pos = knight.getPossibleMoves(boardSnapshot);
        AnsiConsole.systemUninstall();
    }
}
