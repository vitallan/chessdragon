package com.allan.game;

import com.allan.player.Player;

public class Game {

	private Board board;
	
	public Game(Player playerWhite, Player playerBlack) {
		this.board = new Board(playerWhite, playerBlack);
	}
	
	public boolean isFinished() {
		return true;
	}
	
	public Player winner() {
		return null;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void checkWarnings() {
		
	}
	
}
