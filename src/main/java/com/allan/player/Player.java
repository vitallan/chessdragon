package com.allan.player;

import com.allan.game.Piece;
import com.allan.set.BoardProxy;
import com.allan.set.PlayerSet;


public interface Player {
	
	void setPieces(PlayerSet set);
	Piece move();
	void setBoard(BoardProxy board);
	PlayerSet getSet();
	
}
