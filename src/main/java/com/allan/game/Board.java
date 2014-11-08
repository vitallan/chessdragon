package com.allan.game;

import com.allan.set.PlayerSet;

public class Board {

	private String[][] realBoard = new String[8][8];
	
	public PlayerSet deployWhite() {
		PlayerSet pieces = null;
		return pieces;
	}
	
	public PlayerSet deployBlack() {
		PlayerSet pieces = null;
		return pieces;
	}
	
	
	public void printBoard() {
		for (int i = 0; i < realBoard.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < realBoard[i].length; j++) {
				System.out.print(i + " - " + j + " ");
			}
			System.out.print("]\n");
		}
	}
	
}
