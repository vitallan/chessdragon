package com.allan.player;

import java.util.List;
import java.util.Random;

import com.allan.game.Piece;
import com.allan.set.BoardProxy;
import com.allan.set.Move;
import com.allan.set.PlayerSet;
import com.allan.set.Position;

public class PlayerZero implements Player {

	private PlayerSet set;
	private BoardProxy board;
	
	public void setPieces(PlayerSet set) {
		this.set = set;
	}

	public Move move() {
		List<Piece> pieces = this.set.getPiecesAsList();
		boolean canMove = false;
		Piece pieceToMove = null;
		List<Position> positionsToGo = null;
		while (!canMove) {
			pieceToMove = pieces.get(this.getRandomIndex(pieces.size()));
			positionsToGo = pieceToMove.getPossibleMoves(this.board.getBoardSnapshot());
			if (positionsToGo.size() > 0) {
				canMove = true;
			}
		}
		Position positionToGo = positionsToGo.get(this.getRandomIndex(positionsToGo.size()));
		return new Move(pieceToMove, positionToGo);
	}

	@Override
	public void setBoard(BoardProxy board) {
		this.board = board;
	}

	private int getRandomIndex(int max) {
		int min = 0;
		max = max - 1;
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

}
