package com.allan.piece;

import java.util.ArrayList;
import java.util.List;

import com.allan.game.Piece;
import com.allan.player.Player;
import com.allan.set.Position;

public class King extends Piece {

	public King(Position position, Player player) {
		super(position, player);
	}

	@Override
	public String getAbbreviation() {
		return "K";
	}

	@Override
	public List<Position> getPossibleMoves(Piece[][] board) {
		int i = super.getPosition().getI();
		int j = super.getPosition().getJ();
		
		List<Position> adjacentMoves = new ArrayList<Position>();
		adjacentMoves.add(Position.getByPosition(i + 1, j)); //down one square
		adjacentMoves.add(Position.getByPosition(i - 1, j)); //up one square
		adjacentMoves.add(Position.getByPosition(i, j - 1)); //left one square
		adjacentMoves.add(Position.getByPosition(i, j - 1)); //right one square
		
		adjacentMoves.add(Position.getByPosition(i - 1, j + 1)); //up-right one square
		adjacentMoves.add(Position.getByPosition(i - 1, j - 1)); //up-left one square
		adjacentMoves.add(Position.getByPosition(i + 1, j + 1)); //down-right one square
		adjacentMoves.add(Position.getByPosition(i + 1, j - 1)); //down-left one square

		return super.filterInvalidPositions(adjacentMoves, board);
	}
	
}
