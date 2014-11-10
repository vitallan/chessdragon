package com.allan.game;

import java.util.ArrayList;
import java.util.List;

import com.allan.set.PlayerSet;
import com.allan.set.Position;

public abstract class Piece {
	
	private Position position;
	private int value;
	private PlayerSet set;
	private int BORDER_LIMIT = 8;
	
	protected abstract String getAbbreviation();
	public abstract List<Position> getPossibleMoves(Piece[][] board);
	
	public Piece(int value, PlayerSet set) {
		this.value = value;
		this.set = set;
	}
	
	public PlayerSet getPlayerSet() {
		return this.set;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	protected void setPosition(Position position) {
		this.position = position;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	@Override
	public String toString() {
		return this.getAbbreviation() + "-" + position;
	}
	
	protected List<Position> lookPositionsUp(Piece[][] board) {
		int i = this.position.getI() - 1;
		List<Position> positions = new ArrayList<Position>();
		while (i >= 0) {
			if (board[i][this.position.getJ()] == null) {
				positions.add(Position.getByPosition(i, this.position.getJ()));
			} else {
				break;
			}
			i--;
		}
		return positions;
	}
	
	protected List<Position> lookPositionsDown(Piece[][] board) {
		int i = this.position.getI() + 1;
		List<Position> positions = new ArrayList<Position>();
		while (i < BORDER_LIMIT) {
			if (board[i][this.position.getJ()] == null) {
				positions.add(Position.getByPosition(i, this.position.getJ()));
			} else {
				break;
			}
			i++;
		}
		return positions;
	}
	
	protected List<Position> lookPositionsRight(Piece[][] board) {
		int j = this.position.getJ() + 1;
		List<Position> positions = new ArrayList<Position>();
		while (j < BORDER_LIMIT) {
			if (board[this.position.getI()][j] == null) {
				positions.add(Position.getByPosition(this.position.getI(), j));
			} else {
				break;
			}
			j++;
		}
		return positions;
	}
	
	protected List<Position> lookPositionsLeft(Piece[][] board) {
		int j = this.position.getJ() - 1;
		List<Position> positions = new ArrayList<Position>();
		while (j >= 0) {
			if (board[this.position.getI()][j] == null) {
				positions.add(Position.getByPosition(this.position.getI(), j));
			} else {
				break;
			}
			j--;
		}
		return positions;
	}
	
	protected List<Position> lookPositionsDiagonalLeftUp(Piece[][] board) {
		int j = this.position.getJ() - 1;
		int i = this.position.getI() - 1;
		List<Position> positions = new ArrayList<Position>();
		while (i >= 0 && j >= 0) {
			if (board[i][j] == null) {
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
		int j = this.position.getJ() + 1;
		int i = this.position.getI() - 1;
		List<Position> positions = new ArrayList<Position>();
		while (i >= 0 && j < BORDER_LIMIT) {
			if (board[i][j] == null) {
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
		int j = this.position.getJ() - 1;
		int i = this.position.getI() + 1;
		List<Position> positions = new ArrayList<Position>();
		while (i < BORDER_LIMIT && j >= 0) {
			if (board[i][j] == null) {
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
		int j = this.position.getJ() + 1;
		int i = this.position.getI() + 1;
		List<Position> positions = new ArrayList<Position>();
		while (i < BORDER_LIMIT && j < BORDER_LIMIT) {
			if (board[i][j] == null) {
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
			if (pos != null && board[pos.getI()][pos.getJ()] == null) {
				possibleMoves.add(pos);
			}
		}
		return possibleMoves;
	}
	
}
