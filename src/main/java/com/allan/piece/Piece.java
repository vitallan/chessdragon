package com.allan.piece;

import com.allan.set.Position;

public abstract class Piece {
	
	private Position position;
	private int value;
	
	public Piece(int value) {
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
}
