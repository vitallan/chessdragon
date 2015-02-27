package com.allan.util;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.Color.WHITE;
import static org.fusesource.jansi.Ansi.Color.YELLOW;

import java.util.ArrayList;
import java.util.List;

import org.fusesource.jansi.Ansi.Color;

import com.allan.game.Piece;
import com.allan.player.Player;
import com.allan.set.Move;
import com.allan.set.PlayerSet;
import com.allan.set.Position;

public class Utils {
	
	public static void printBoard(Piece[][] realBoard, Player whitePlayer) {
		for (int i = 0; i < realBoard.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < realBoard[i].length; j++) {
				printPiece(realBoard, i, j, whitePlayer);
				System.out.print("(" + i + "-" + j + ")");
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
			return realBoard[i][j].getPlayerSet().getPlayer();
		} 
		return null;
	}
	
	public static List<Piece> isKingInCheck(PlayerSet justMoved, PlayerSet isInCheck, Piece[][] realBoard) {
		List<Move> nextPossibleMoves = justMoved.getAllPossibleMoves(realBoard);
		List<Piece> checkPieces = new ArrayList<Piece>();
		for (Move move : nextPossibleMoves) {
			if (move.getFuturePosition().equals(isInCheck.king.getPosition())) {
				checkPieces.add(move.getPiece());
			}
		}
		return checkPieces;
	}
	
	public static boolean isKingInCheckMate(PlayerSet justMoved, PlayerSet isInCheck, Piece[][] realBoard) {
		List<Piece> menacingPieces = isKingInCheck(justMoved, isInCheck, realBoard);
		if (menacingPieces.isEmpty()) {
			return false;
		}
		// WIP in here, this method will be refactored soon
		//check if king can move to safety
		List<Position> possibleKingPositions = isInCheck.king.getPossibleMoves(realBoard);
		for (Position position : possibleKingPositions) {
			boolean canIMoveThere = true;
			List<Position> agressivePositions = justMoved.getAllPossiblePositions(realBoard);
			for (Position agressivePosition : agressivePositions) {
				if (agressivePosition.equals(position)) {
					canIMoveThere = false;
					break;
				}
			}
			if (canIMoveThere) {
				return false;
			}
		}
		List<Position> possibleMoves = isInCheck.getAllPossiblePositions(realBoard);
		// check if i can capture the attacking piece, if there is only one menacing me
		if (menacingPieces.size() == 1) {
			Piece agressivePiece = menacingPieces.get(0);
			Position toCapture = agressivePiece.getPosition();
			if (possibleMoves.contains(toCapture)) {
				return false;
			}
		}
		
		// check if i can block the attacking piece(s) (using, sadly, brute force right now)
		Move move = canItBeBlocked(justMoved, isInCheck, realBoard);
		if (move != null) {
			return false;
		}
		return true;
	}
	
	private static Move canItBeBlocked(PlayerSet justMoved, PlayerSet isInCheck, Piece[][] board) {
		List<Move> myMoves = isInCheck.getAllPossibleMoves(board);
		Piece[][] tempBoard = board.clone();
		for (Move move : myMoves) {
			Piece piece = move.getPiece();
			tempBoard[piece.getPosition().getI()][piece.getPosition().getJ()] = null;
			tempBoard[move.getFuturePosition().getI()][move.getFuturePosition().getJ()] = move.getPiece();
			if (isKingInCheck(justMoved, isInCheck, tempBoard).isEmpty()) {
				return move;
			}
			tempBoard[move.getFuturePosition().getI()][move.getFuturePosition().getJ()] = null;
			tempBoard[piece.getPosition().getI()][piece.getPosition().getJ()] = move.getPiece();
		}
		return null;
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
