package com.allan.piece;

import java.util.ArrayList;
import java.util.List;

import com.allan.game.Piece;
import com.allan.set.PlayerSet;
import com.allan.set.Position;

public class Pawn extends Piece {

	private boolean movesUp;
	private boolean firstMove;
	
	public Pawn(PlayerSet set) {
		super(1, set);
	}
	
	public void setMovesUp(boolean movesUp) {
		this.movesUp = movesUp;
	}
	
	@Override
	public String getAbbreviation() {
		return "p";
	}

	@Override
	public List<Position> getPossibleMoves(Piece[][] board) {
		List<Position> possibleMoves = new ArrayList<Position>();
		int i = super.getPosition().getI();
		int j = super.getPosition().getJ();
		if (firstMove) {
			possibleMoves.add(Position.getByPosition(i - 1, j));
			possibleMoves.add(Position.getByPosition(i - 2, j));
		} else {
			possibleMoves.add(Position.getByPosition(i - 1, j));
		}
		return super.filterInvalidPositions(possibleMoves, board);
	}
	
}
