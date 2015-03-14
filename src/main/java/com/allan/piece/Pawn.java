package com.allan.piece;

import java.util.ArrayList;
import java.util.List;

import com.allan.game.Piece;
import com.allan.player.Player;
import com.allan.set.Position;

public class Pawn extends Piece {

	public Pawn(Position position, Player player) {
		super(position, player);
	}
	
	private boolean movesUp;

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
		int j = super.getPosition().getJ();
		int oneStepAhead = getOneStepAhead();
		int twoStepsAhead = getTwoStepsAhead();
		if (!super.isBeyondBorders(oneStepAhead, j) && board[oneStepAhead][j] == null) {
			possibleMoves.add(Position.getByPosition(oneStepAhead, j));
			if (!super.isBeyondBorders(twoStepsAhead, j) && getFirstMove() && (board[twoStepsAhead][j] == null)) {
				possibleMoves.add(Position.getByPosition(twoStepsAhead, j));
			}
		}
		possibleMoves.addAll(getDiagonalsInFront(board));
		return super.filterInvalidPositions(possibleMoves, board);
	}

	private List<Position> getDiagonalsInFront(Piece[][] board) {
		List<Position> positions = new ArrayList<Position>();
		Position diagonalRight = Position.getByPosition(getOneStepAhead(),getJ() + 1);
		Position diagonalLeft = Position.getByPosition(getOneStepAhead(),getJ() - 1);
		if (diagonalRight != null && isPositionWithEnemyPiece(diagonalRight.getI(), diagonalRight.getJ(), board)) {
			positions.add(diagonalRight);
		}
		if (diagonalLeft != null && isPositionWithEnemyPiece(diagonalLeft.getI(), diagonalLeft.getJ(), board)) {
			positions.add(diagonalLeft);
		}
		return positions;
	}

	private int getOneStepAhead() {
		return this.getStepsAhead(1);
	}

	private int getTwoStepsAhead() {
		return this.getStepsAhead(2);
	}
	
	private int getStepsAhead(int steps) {
		int i = super.getPosition().getI();
		if (movesUp) {
			return i - steps;
		} else {
			return i + steps;
		}
	}

}
