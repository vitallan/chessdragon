package com.allan.game;

import com.allan.player.Player;

public class Game {

	private Board board;
	
	private Player playerWhite;
	private Player playerBlack;
	
	public Game(Player playerWhite, Player playerBlack) {
		this.playerBlack = playerBlack;
		this.playerWhite = playerWhite;
		this.board = new Board(this.playerWhite, this.playerBlack);
		playerBlack.setPieces(this.board.deployBlack());
		playerWhite.setPieces(this.board.deployWhite());
		board.sendBoardSnapshotToPlayers();
	}
	
	public boolean isFinished() {
		return true;
	}
	
	public Player winner() {
		return playerWhite;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void checkWarnings() {
		
	}
	
}
