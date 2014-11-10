package com.allan.piece;

import java.util.ArrayList;
import java.util.List;

import com.allan.game.Piece;
import com.allan.set.PlayerSet;
import com.allan.set.Position;

public class Rook extends Piece {
	
	public Rook(PlayerSet set) {
		super(5, set);
	}
	
	@Override
	public String getAbbreviation() {
		return "R";
	}
	
	@Override
	public List<Position> getPossibleMoves(Piece[][] board) {
		List<Position> possibleMoves = new ArrayList<Position>();
		possibleMoves.addAll(super.lookPositionsUp(board));
		possibleMoves.addAll(super.lookPositionsDown(board));
		possibleMoves.addAll(super.lookPositionsRight(board));
		possibleMoves.addAll(super.lookPositionsLeft(board));
		return possibleMoves;
	}
	
}
