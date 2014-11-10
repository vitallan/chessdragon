package com.allan.piece;

import java.util.ArrayList;
import java.util.List;

import com.allan.game.Piece;
import com.allan.set.PlayerSet;
import com.allan.set.Position;

public class Queen extends Piece{

	public Queen(PlayerSet set) {
		super(10, set);
	}
	
	@Override
	public String getAbbreviation() {
		return "Q";
	}

	@Override
	public List<Position> getPossibleMoves(Piece[][] board) {
		List<Position> possibleMoves = new ArrayList<Position>();
		possibleMoves.addAll(super.lookPositionsDiagonalLeftUp(board));
		possibleMoves.addAll(super.lookPositionsDiagonalLeftDown(board));
		possibleMoves.addAll(super.lookPositionsDiagonalRightUp(board));
		possibleMoves.addAll(super.lookPositionsDiagonalRightDown(board));
		possibleMoves.addAll(super.lookPositionsUp(board));
		possibleMoves.addAll(super.lookPositionsDown(board));
		possibleMoves.addAll(super.lookPositionsRight(board));
		possibleMoves.addAll(super.lookPositionsLeft(board));
		return possibleMoves;
	}
	
}
