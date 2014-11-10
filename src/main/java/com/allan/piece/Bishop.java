package com.allan.piece;

import java.util.ArrayList;
import java.util.List;

import com.allan.game.Piece;
import com.allan.set.PlayerSet;
import com.allan.set.Position;

public class Bishop extends Piece {

	public Bishop(PlayerSet set) {
		super(3, set);
	}
	
	@Override
	public String getAbbreviation() {
		return "B";
	}

	@Override
	public List<Position> getPossibleMoves(Piece[][] board) {
		List<Position> possibleMoves = new ArrayList<Position>();
		possibleMoves.addAll(super.lookPositionsDiagonalLeftUp(board));
		possibleMoves.addAll(super.lookPositionsDiagonalLeftDown(board));
		possibleMoves.addAll(super.lookPositionsDiagonalRightUp(board));
		possibleMoves.addAll(super.lookPositionsDiagonalRightDown(board));
		return possibleMoves;
	}
	
}
