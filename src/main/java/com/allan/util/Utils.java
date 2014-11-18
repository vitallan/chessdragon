package com.allan.util;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.Color.WHITE;
import static org.fusesource.jansi.Ansi.Color.YELLOW;

import org.fusesource.jansi.Ansi.Color;

import com.allan.game.Piece;
import com.allan.player.Player;
import com.allan.set.PlayerSet;
import com.allan.set.Position;

public class Utils {
	
	public static void printBoard(Piece[][] realBoard, Player whitePlayer) {
		for (int i = 0; i < realBoard.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < realBoard[i].length; j++) {
				if (!(realBoard[i][j] == null)) {
					Color color;
					if (getPlayerOwner(i,j, realBoard).equals(whitePlayer)) {
						color = WHITE;
					} else {
						color = YELLOW;
					}
					System.out.print(ansi().fg(color).a(realBoard[i][j]).reset() + " ");
				} else {
					System.out.print(ansi().fg(RED).a("(" + Position.getByPosition(i, j) + ") ").reset());
				}
			}
			System.out.print("]\n");
		}
	}
	
	private static Player getPlayerOwner(int i, int j, Piece[][] realBoard) {
		if (realBoard[i][j] != null) {
			return realBoard[i][j].getPlayerSet().getPlayer();
		} 
		return null;
	}
	
	public static boolean isKingInCheck(PlayerSet justMoved, PlayerSet isInCheck, Piece[][] realBoard) {
		return false;
	}
	
	public static boolean isKingInCheckMate(PlayerSet justMoved, PlayerSet isInCheck, Piece[][] realBoard) {
		return false;
	}
	
	public static void setPiecesPosition(Position[] positions, PlayerSet set) {
		set.pawn_1.setPosition(positions[0]);
		set.pawn_2.setPosition(positions[1]);
		set.pawn_3.setPosition(positions[2]);
		set.pawn_4.setPosition(positions[3]);
		set.pawn_5.setPosition(positions[4]);
		set.pawn_6.setPosition(positions[5]);
		set.pawn_7.setPosition(positions[6]);
		set.pawn_8.setPosition(positions[7]); 

		set.rook_1.setPosition(positions[8]);
		set.rook_2.setPosition(positions[9]);

		set.knight_1.setPosition(positions[10]);
		set.knight_2.setPosition(positions[11]);

		set.bishop_1.setPosition(positions[12]);
		set.bishop_2.setPosition(positions[13]);

		set.queen.setPosition(positions[14]);
		set.king.setPosition(positions[15]);
	
	}
	
}
