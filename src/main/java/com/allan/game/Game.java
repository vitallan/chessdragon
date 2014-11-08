package com.allan.game;

import com.allan.player.Player;

public class Game {

	private Board board;
	
	private Player playerWhite;
	private Player playerBlack;
	
	public Game(Player playerWhite, Player playerBlack) {
		this.playerBlack = playerBlack;
		this.playerWhite = playerWhite;
	}
	
	public boolean isFinished() {
		return false;
	}
	
	public Player winner() {
		return playerWhite;
	}
	
	public Board getBoard() {
		return board;
	}
	
}
