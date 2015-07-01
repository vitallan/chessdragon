package com.allan.piece;

import java.util.ArrayList;
import java.util.List;

import com.allan.player.Player;
import com.allan.set.Position;

public class Rook extends Piece {

	public Rook(Position position, Player player) {
		super(position, player);
	}
	
	@Override
	public String getAbbreviation() {
		return "R";
	}
	
	@Override
	public List<Position> getPossiblePositions(Piece[][] board) {
		List<Position> possibleMoves = new ArrayList<Position>();
		possibleMoves.addAll(super.lookPositionsUp(board));
		possibleMoves.addAll(super.lookPositionsDown(board));
		possibleMoves.addAll(super.lookPositionsRight(board));
		possibleMoves.addAll(super.lookPositionsLeft(board));
		return possibleMoves;
	}
	
}
