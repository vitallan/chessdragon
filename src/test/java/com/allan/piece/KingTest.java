package com.allan.piece;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.allan.game.Board;
import com.allan.player.Player;
import com.allan.player.PlayerEmpty;
import com.allan.set.Position;

public class KingTest {
	
	private Player whitePlayer;
	private Player blackPlayer;
	
	private King king;
	private Board board;
	
	@Before
	public void init() {
		whitePlayer = new PlayerEmpty();
		blackPlayer = new PlayerEmpty();
		
		List<Piece> whitePieces = new ArrayList<Piece>();
		king = new King(Position.A1, whitePlayer);
		whitePieces.add(king);
		
		board = new Board(whitePieces, new ArrayList<Piece>());
	}
	
	@Test
	public void corner1_test() {
		List<Position> possibleMoves = king.getPossiblePositions(board.getRealBoard());
		List<Position> expected = new ArrayList<Position>();
		expected.add(Position.A2);
		expected.add(Position.B1);
		expected.add(Position.B2);
		assertEquals(expected, possibleMoves);
	}
	
}
