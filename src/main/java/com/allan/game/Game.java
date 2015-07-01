package com.allan.game;

import java.util.ArrayList;
import java.util.List;

import com.allan.piece.Bishop;
import com.allan.piece.King;
import com.allan.piece.Knight;
import com.allan.piece.Pawn;
import com.allan.piece.Piece;
import com.allan.piece.Queen;
import com.allan.piece.Rook;
import com.allan.player.Player;
import com.allan.set.Position;

public class Game {
	
	public Game(Player playerWhite, Player playerBlack) {
		List<Piece> whitePieces = buildWhitePieces(playerWhite);
		List<Piece> blackPieces = buildBlackPieces(playerBlack);
		playerWhite.setPieces(whitePieces);
		playerWhite.setMovesUp(true);
		playerBlack.setPieces(blackPieces);
		new Board(whitePieces, blackPieces);
	}
	
	public boolean isFinished() {
		return true;
	}
	
	public Player winner() {
		return null;
	}
	
	private List<Piece> buildWhitePieces(Player player) {
		Position[] positions = new Position[16];
		
		positions[0] = Position.E8;
		positions[1] = Position.D8;
		positions[2] = Position.A8;
		positions[3] = Position.H8;
		positions[4] = Position.B8;
		positions[5] = Position.G8;
		positions[6] = Position.F8;
		positions[7] = Position.C8;
		
		positions[8] = Position.A7;
		positions[9] = Position.H7;
		positions[10] = Position.B7;
		positions[11] = Position.G7;
		positions[12] = Position.C7;
		positions[13] = Position.F7;
		positions[14] = Position.D7;
		positions[15] = Position.E7;
		return createPieces(positions, player);
	}
	
	private List<Piece> buildBlackPieces(Player player) {
		Position[] positions = new Position[16];
		
		positions[0] = Position.E1;
		positions[1] = Position.D1;
		positions[2] = Position.A1;
		positions[3] = Position.H1;
		positions[4] = Position.B1;
		positions[5] = Position.G1;
		positions[6] = Position.F1;
		positions[7] = Position.C1;
		
		positions[8] = Position.A2;
		positions[9] = Position.H2;
		positions[10] = Position.B2;
		positions[11] = Position.G2;
		positions[12] = Position.C2;
		positions[13] = Position.F2;
		positions[14] = Position.D2;
		positions[15] = Position.E2;
		
		return createPieces(positions, player);
	}
	
	private List<Piece> createPieces(Position[] position, Player player) {
		List<Piece> pieces = new ArrayList<Piece>();
		//how can i refactor this?
		Piece piece = new King(position[0], player);
		pieces.add(piece);
		piece = new Queen(position[1], player);
		pieces.add(piece);
		piece = new Rook(position[2], player);
		pieces.add(piece);
		piece = new Rook(position[3], player);
		pieces.add(piece);
		piece = new Knight(position[4], player);
		pieces.add(piece);
		piece = new Knight(position[5], player);
		pieces.add(piece);
		piece = new Bishop(position[6], player);
		pieces.add(piece);
		piece = new Bishop(position[7], player);
		pieces.add(piece);
		piece = new Pawn(position[8], player);
		pieces.add(piece);
		piece = new Pawn(position[9], player);
		pieces.add(piece);
		piece = new Pawn(position[10], player);
		pieces.add(piece);
		piece = new Pawn(position[11], player);
		pieces.add(piece);
		piece = new Pawn(position[12], player);
		pieces.add(piece);
		piece = new Pawn(position[13], player);
		pieces.add(piece);
		piece = new Pawn(position[14], player);
		pieces.add(piece);
		piece = new Pawn(position[15], player);
		pieces.add(piece);
		return pieces;
	}
	
}
