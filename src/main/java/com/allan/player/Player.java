package com.allan.player;

import java.util.List;

import com.allan.game.Piece;
import com.allan.set.Move;


public interface Player {
	
	void setPieces(List<Piece> pieces);
	Move move(Piece[][] board);
	boolean isInMyPieces(Piece piece);
	
}
