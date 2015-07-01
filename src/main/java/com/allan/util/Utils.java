package com.allan.util;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.Color.WHITE;
import static org.fusesource.jansi.Ansi.Color.YELLOW;

import org.fusesource.jansi.Ansi.Color;

import com.allan.piece.Piece;
import com.allan.player.Player;
import com.allan.set.Position;

public class Utils {
	
	public static void printBoard(Piece[][] realBoard, Player whitePlayer) {
		for (int i = 0; i < realBoard.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < realBoard[i].length; j++) {
				printPiece(realBoard, i, j, whitePlayer);
			}
			System.out.print("]\n");
		}
	}
	
	private static void printPiece(Piece[][] realBoard, int i, int j, Player whitePlayer) {
		if (!(realBoard[i][j] == null)) {
			Color color;
			String player;
			if (getPlayerOwner(i,j, realBoard).equals(whitePlayer)) {
				color = WHITE;
				player = "W";
			} else {
				player = "B";
				color = YELLOW;
			}
			System.out.print(player + "|" + ansi().fg(color).a(realBoard[i][j]).reset() + " ");
		} else {
			System.out.print(ansi().fg(RED).a("( " + Position.getByPosition(i, j) + " ) ").reset());
		}
	}
	
	private static Player getPlayerOwner(int i, int j, Piece[][] realBoard) {
		if (realBoard[i][j] != null) {
			return realBoard[i][j].getPlayer();
		} 
		return null;
	}
	
	
}
