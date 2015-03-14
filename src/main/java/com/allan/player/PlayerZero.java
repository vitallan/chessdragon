package com.allan.player;

import java.util.List;
import java.util.Random;

import com.allan.game.Piece;
import com.allan.set.Move;
import com.allan.set.Position;

public class PlayerZero implements Player {

	private List<Piece> set;
	
	public void setPieces(List<Piece> set) {
		this.set = set;
	}

	public Move move(Piece[][] board) {
		boolean canMove = false;
		Piece pieceToMove = null;
		List<Position> positionsToGo = null;
		while (!canMove) {
			pieceToMove = set.get(this.getRandomIndex(set.size()));
			positionsToGo = pieceToMove.getPossibleMoves(board);
			if (positionsToGo.size() > 0) {
				canMove = true;
			}
		}
		Position positionToGo = positionsToGo.get(this.getRandomIndex(positionsToGo.size()));
		return new Move(pieceToMove, positionToGo);
	}

	private int getRandomIndex(int max) {
		int min = 0;
		max = max - 1;
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

	@Override
	public boolean isInMyPieces(Piece piece) {
		// TODO Auto-generated method stub
		return false;
	}

}
