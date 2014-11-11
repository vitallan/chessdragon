package com.allan.set;

import com.allan.game.Piece;

public class Move {
	
	private Piece piece;
	private Position futurePosition;
	
	public Move(Piece piece, Position futurePosition) {
		this.piece = piece;
		this.futurePosition = futurePosition;
	}
	
	public Piece getPiece(){
		return this.piece;
	}
	
	public Position getFuturePosition() {
		return this.futurePosition;
	}
	
}	
