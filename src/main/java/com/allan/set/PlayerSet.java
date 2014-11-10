package com.allan.set;

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
		//TODO: change here
		pawn_1.setMovesUp(isWhitePlayer);
		pawn_1.setMovesUp(isWhitePlayer);
		pawn_1.setMovesUp(isWhitePlayer);
		pawn_1.setMovesUp(isWhitePlayer);
		pawn_1.setMovesUp(isWhitePlayer);
	}
	
}
