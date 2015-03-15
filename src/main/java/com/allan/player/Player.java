package com.allan.player;

import java.util.List;

import com.allan.game.Piece;
import com.allan.set.Move;


public abstract class Player {
	
	protected List<Piece> set;
	private boolean movesUp = false;
	
	public abstract Move move(Piece[][] board);
	
	public void setPieces(List<Piece> pieces) {
		this.set = pieces;
	}
	
	public boolean isInMyPieces(Piece piece) {
		return set.contains(piece);
	}
	
	public void setMovesUp(boolean movesUp) {
		this.movesUp = movesUp;
	}
	
	public boolean getMovesUp() {
		return this.movesUp;
	}
	
}
