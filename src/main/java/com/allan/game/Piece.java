package com.allan.game;

import java.util.ArrayList;
import java.util.List;

import com.allan.player.Player;
import com.allan.set.Position;

public abstract class Piece {
	
	private Position position;
	private Player player;
	private int BORDER_LIMIT = 8;
	private boolean firstMove = true;
	
	public abstract String getAbbreviation();
	public abstract List<Position> getPossibleMoves(Piece[][] board);
	
	public Piece(Position position, Player player) {
		this.position = position;
		this.player = player;
	}
	
	public boolean getFirstMove() {
		return this.firstMove;
	}
	
	public void setFirstMove(boolean firstMove) {
		this.firstMove = firstMove;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	protected int getI() {
		return this.getPosition().getI();
	}
	
	protected int getJ() {
		return this.getPosition().getJ();
	}
	
	@Override
	public String toString() {
		return this.getAbbreviation() + "-" + position;
	}
	
	protected List<Position> lookPositionsUp(Piece[][] board) {
		int i = this.getI() - 1;
		List<Position> positions = new ArrayList<Position>();
		while (i >= 0) {
			if (isThisPositionValid(i, getJ(), board)) {
				positions.add(Position.getByPosition(i, getJ()));
			} else {
				break;
			}
			i--;
		}
		return positions;
	}
	
	protected List<Position> lookPositionsDown(Piece[][] board) {
		int i = getI() + 1;
		List<Position> positions = new ArrayList<Position>();
		while (i < BORDER_LIMIT) {
			if (isThisPositionValid(i, getJ(), board)) {
				positions.add(Position.getByPosition(i, getJ()));
			} else {
				break;
			}
			i++;
		}
		return positions;
	}
	
	protected List<Position> lookPositionsRight(Piece[][] board) {
		int j = getJ() + 1;
		List<Position> positions = new ArrayList<Position>();
		while (j < BORDER_LIMIT) {
			if (isThisPositionValid(getI(), j, board)) {
				positions.add(Position.getByPosition(getI(), j));
			} else {
				break;
			}
			j++;
		}
		return positions;
	}
	
	protected List<Position> lookPositionsLeft(Piece[][] board) {
		int j = getJ() - 1;
		List<Position> positions = new ArrayList<Position>();
		while (j >= 0) {
			if (isThisPositionValid(getI(), j, board)) {
				positions.add(Position.getByPosition(getI(), j));
			} else {
				break;
			}
			j--;
		}
		return positions;
	}
	
	protected List<Position> lookPositionsDiagonalLeftUp(Piece[][] board) {
		int j = getJ() - 1;
		int i = getI() - 1;
		List<Position> positions = new ArrayList<Position>();
		while (i >= 0 && j >= 0) {
			if (isThisPositionValid(i, j, board)) {
				positions.add(Position.getByPosition(i, j));
			} else {
				break;
			}
			i--;
			j--;
		}
		return positions;
	}
	
	protected List<Position> lookPositionsDiagonalRightUp(Piece[][] board) {
		int j = getJ() + 1;
		int i = getI() - 1;
		List<Position> positions = new ArrayList<Position>();
		while (i >= 0 && j < BORDER_LIMIT) {
			if (isThisPositionValid(i, j, board)) {
				positions.add(Position.getByPosition(i, j));
			} else {
				break;
			}
			i--;
			j++;
		}
		return positions;
	}
	
	protected List<Position> lookPositionsDiagonalLeftDown(Piece[][] board) {
		int j = getJ() - 1;
		int i = getI() + 1;
		List<Position> positions = new ArrayList<Position>();
		while (i < BORDER_LIMIT && j >= 0) {
			if (isThisPositionValid(i, j, board)) {
				positions.add(Position.getByPosition(i, j));
			} else {
				break;
			}
			i++;
			j--;
		}
		return positions;
	}
	
	protected List<Position> lookPositionsDiagonalRightDown(Piece[][] board) {
		int j = getJ() + 1;
		int i = getI() + 1;
		List<Position> positions = new ArrayList<Position>();
		while (i < BORDER_LIMIT && j < BORDER_LIMIT) {
			if (isThisPositionValid(i, j, board)) {
				positions.add(Position.getByPosition(i, j));
			} else {
				break;
			}
			i++;
			j++;
		}
		return positions;
	}
	
	// check for positions that are, either out of board, or over other piece(s)
	protected List<Position> filterInvalidPositions(List<Position> uncertainPositions, Piece[][] board) {
		List<Position> possibleMoves = new ArrayList<Position>();
		for (Position pos : uncertainPositions) {
			if (pos != null && isThisPositionValid(pos.getI(), pos.getJ(), board)) {
				possibleMoves.add(pos);
			}
		}
		return possibleMoves;
	}
	
	protected boolean isThisPositionValid(int i, int j, Piece[][] board) {
		return !isBeyondBorders(i,j) && (isPositionEmpty(i, j, board) || isPositionWithEnemyPiece(i, j, board));
	}
	
	protected boolean isPositionEmpty(int i, int j, Piece[][] board) {
		return board[i][j] == null;
	}
	
	protected boolean isPositionWithEnemyPiece(int i, int j, Piece[][] board) {
		return (board[i][j] != null && !this.player.isInMyPieces(board[i][j]));
	}
	
	protected boolean isBeyondBorders(int i, int j) {
		return i < 0 || j < 0 || i > BORDER_LIMIT || j > BORDER_LIMIT;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
