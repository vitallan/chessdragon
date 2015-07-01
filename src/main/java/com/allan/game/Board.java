package com.allan.game;

import java.util.List;

import com.allan.exception.IllegalMoveException;
import com.allan.piece.Piece;
import com.allan.set.Position;

public class Board {

	private Piece[][] realBoard;
	
	public Board(List<Piece> whitePieces, List<Piece> blackPieces) {
		realBoard = new Piece[8][8];
		
		this.setPiecesInBoard(blackPieces);
		this.setPiecesInBoard(whitePieces);
	}
	
	public Piece[][] getRealBoard() {
		return this.realBoard.clone();
	}
	
	private void setPiecesInBoard(List<Piece> pieces) {
		for (Piece piece : pieces) {
			this.setPieceInBoard(piece);
		}
	}
	
	private void setPieceInBoard(Piece piece) {
		realBoard[piece.getI()][piece.getJ()] = piece;
	}
	
	public void move(Piece piece, Position nextPosition) throws IllegalMoveException {
		Position currentPosition = piece.getPosition();
		if (!piece.getPossiblePositions(this.realBoard).contains(nextPosition)) {
			throw new IllegalMoveException("[ " + piece.getAbbreviation() + " in " + currentPosition + "] Cant go to " + nextPosition );
		}
		realBoard[currentPosition.getI()][currentPosition.getJ()] = null;
		piece.setPosition(nextPosition); 
		killPiece(nextPosition);
		piece.setPosition(nextPosition); //just to make sure
		this.setPieceInBoard(piece);
		piece.setFirstMove(false);
	}

	private void killPiece(Position position) {
		Piece deadPiece = this.realBoard[position.getI()][position.getJ()];
		if (deadPiece != null) {
			deadPiece.setPosition(null);
			deadPiece = null;
		}
	}
		
}
