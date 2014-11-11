package com.allan.player;

import com.allan.set.BoardProxy;
import com.allan.set.Move;
import com.allan.set.PlayerSet;


public interface Player {
	
	void setPieces(PlayerSet set);
	Move move();
	void setBoard(BoardProxy board);
	
}
