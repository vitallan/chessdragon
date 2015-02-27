package com.allan.set;

import java.util.ArrayList;
import java.util.List;

import com.allan.game.Piece;
import com.allan.piece.Bishop;
import com.allan.piece.King;
import com.allan.piece.Knight;
import com.allan.piece.Pawn;
import com.allan.piece.Queen;
import com.allan.piece.Rook;
import com.allan.player.Player;

public class PlayerSet {

	private boolean whitePlayer;

	public Rook rook_1 = new Rook(this);
	public Rook rook_2 = new Rook(this);

	public Knight knight_1 = new Knight(this);
	public Knight knight_2 = new Knight(this);

	public Bishop bishop_1 = new Bishop(this);
	public Bishop bishop_2 = new Bishop(this);

	public King king = new King(this);

	public Queen queen = new Queen(this);

	public Pawn pawn_1 = new Pawn(this);
	public Pawn pawn_2 = new Pawn(this);
	public Pawn pawn_3 = new Pawn(this);
	public Pawn pawn_4 = new Pawn(this);
	public Pawn pawn_5 = new Pawn(this);
	public Pawn pawn_6 = new Pawn(this);
	public Pawn pawn_7 = new Pawn(this);
	public Pawn pawn_8 = new Pawn(this);

	private Player player;

	public PlayerSet(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

	public boolean isWhitePlayer() {
		return whitePlayer;
	}

	public void setWhitePlayer(boolean isWhitePlayer) {
		this.whitePlayer = isWhitePlayer;
		pawn_1.setMovesUp(isWhitePlayer);
		pawn_2.setMovesUp(isWhitePlayer);
		pawn_3.setMovesUp(isWhitePlayer);
		pawn_4.setMovesUp(isWhitePlayer);
		pawn_5.setMovesUp(isWhitePlayer);
		pawn_6.setMovesUp(isWhitePlayer);
		pawn_7.setMovesUp(isWhitePlayer);
		pawn_8.setMovesUp(isWhitePlayer); //maybe put MovesUp in all pieces?
	}

	public boolean belongsToThisSet(Piece piece) {
		for (Piece myPiece : this.getPiecesAsList()) {
			if(myPiece == piece){
				return true;
			}
		}
		return false;
	}
	
	public Piece getSpecificPiece(Piece piece) {
		for (Piece myPiece : this.getPiecesAsList()) {
			if (myPiece.equals(piece)) {
				return myPiece;
			}
		}
		return null;
	}
	
	public List<Move> getAllPossibleMoves(Piece[][] board) {
		List<Move> moves = new ArrayList<Move>();
		List<Piece> pieces = this.getPiecesAsList();
		for (int i = 0; i < pieces.size(); i++) {
			Piece piece = pieces.get(i);
			if (piece.getPosition() == null) {
				continue;
			}
			for (Position position : piece.getPossibleMoves(board)) {
				Move move = new Move(piece, position);
				moves.add(move);
			}
		}
		return moves;
	}
	
	public List<Position> getAllPossiblePositions(Piece[][] board) {
		List<Position> positions = new ArrayList<Position>();
		List<Piece> pieces = this.getPiecesAsList();
		for (int i = 0; i < pieces.size(); i++) {
			Piece piece = pieces.get(i);
			if (piece.getPosition() == null) {
				continue;
			}
			positions.addAll(piece.getPossibleMoves(board));
		}
		return positions;
	}

	public List<Piece> getPiecesAsList() {
		List<Piece> piecesList = new ArrayList<Piece>();
		if (king != null) {
			piecesList.add(king);
		}
		if (queen != null) {
			piecesList.add(queen);
		}
		if (bishop_1 != null) {
			piecesList.add(bishop_1);
		}
		if (bishop_2 != null) {
			piecesList.add(bishop_2);
		}
		if (knight_1 != null) {
			piecesList.add(knight_1);
		}
		if (knight_2 != null) {
			piecesList.add(knight_2);
		}
		if (rook_1 != null) {
			piecesList.add(rook_1);
		}
		if (rook_2 != null) {
			piecesList.add(rook_2);
		}
		if (pawn_1 != null) {
			piecesList.add(pawn_1);
		}
		if (pawn_2 != null) {
			piecesList.add(pawn_2);
		}
		if (pawn_3 != null) {
			piecesList.add(pawn_3);
		}
		if (pawn_4 != null) {
			piecesList.add(pawn_4);
		}
		if (pawn_5 != null) {
			piecesList.add(pawn_5);
		}
		if (pawn_6 != null) {
			piecesList.add(pawn_6);
		}
		if (pawn_7 != null) {
			piecesList.add(pawn_7);
		}
		if (pawn_8 != null) {
			piecesList.add(pawn_8);
		}
		return piecesList;
	}

}
