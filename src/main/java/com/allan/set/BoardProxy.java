package com.allan.set;

import com.allan.exception.IllegalMoveException;
import com.allan.game.Board;
import com.allan.game.Piece;

public class BoardProxy {
	
	private Board board;

	public BoardProxy(Board board) {
		this.board = board;
	}
	
	public Piece[][] getBoardSnapshot() {
		return board.getBoardSnapshot();
	}
	
	public void movePiece(Piece piece, Position position) throws IllegalMoveException{
		this.board.movePiece(piece, position);
	}
	
}
