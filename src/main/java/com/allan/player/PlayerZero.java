package com.allan.player;

import com.allan.game.Piece;
import com.allan.set.BoardProxy;
import com.allan.set.PlayerSet;

public class PlayerZero implements Player {

	private PlayerSet set;
	private BoardProxy board;
	private Piece[][] snapshotBoard;
	
	public void setPieces(PlayerSet set) {
		this.set = set;
	}

	public Piece move() {
		return null;
	}

	@Override
	public void setBoard(BoardProxy board) {
		this.board = board;
	}

	@Override
	public PlayerSet getSet() {
		return this.set;
	}

}
