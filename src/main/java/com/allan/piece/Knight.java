package com.allan.piece;

import java.util.ArrayList;
import java.util.List;

import com.allan.game.Piece;
import com.allan.set.PlayerSet;
import com.allan.set.Position;

public class Knight extends Piece{

	public Knight(PlayerSet set) {
		super(2, set);
	}
	
	@Override
	public String getAbbreviation() {
		return "N";
	}

	@Override
	public List<Position> getPossibleMoves(Piece[][] board) {
		int i = super.getPosition().getI();
		int j = super.getPosition().getJ();
		
		List<Position> crazyHorseMoves = new ArrayList<Position>();
		
		crazyHorseMoves.add(Position.getByPosition(i - 2, j + 1));
		crazyHorseMoves.add(Position.getByPosition(i - 2, j - 1));
		crazyHorseMoves.add(Position.getByPosition(i + 2, j + 1));
		crazyHorseMoves.add(Position.getByPosition(i + 2, j - 1));
		
		crazyHorseMoves.add(Position.getByPosition(i + 1, j + 2));
		crazyHorseMoves.add(Position.getByPosition(i + 1, j - 2));
		crazyHorseMoves.add(Position.getByPosition(i - 1, j + 2));
		crazyHorseMoves.add(Position.getByPosition(i - 1, j - 2));
		
		return super.filterInvalidPositions(crazyHorseMoves, board);
	}
	
}
