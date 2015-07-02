package com.allan.piece;

import static org.junit.Assert.*;

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
	
	private List<Piece> whitePieces;
	private List<Piece> blackPieces;
	
	private King king;
	private Board board;
	
	@Before
	public void init() {
		List<Piece> whitePieces = new ArrayList<Piece>();
		king = new King(Position.A1, whitePlayer);
		whitePieces.add(king);
		setWhitePieces(whitePieces);
		setBlackPieces(new ArrayList<Piece>());
		
		setBoard();
	}
	
	private void setWhitePieces(List<Piece> whitePieces) {
		whitePlayer = new PlayerEmpty();
		for (Piece piece : whitePieces) {
			piece.setPlayer(whitePlayer);
		}
		this.whitePieces = whitePieces;
	}
	
	private void setBlackPieces(List<Piece> blackPieces) {
		blackPlayer = new PlayerEmpty();
		for (Piece piece : blackPieces) {
			piece.setPlayer(blackPlayer);
		}
		this.blackPieces = blackPieces;
	}
	
	private void setBoard() {
		board = new Board(whitePieces, blackPieces);
	}
	
	@Test
	public void corner1_test() {
		king.setPosition(Position.A1);
		List<Position> possibleMoves = king.getPossiblePositions(board.getRealBoard());
		List<Position> expected = new ArrayList<Position>();
		expected.add(Position.A2);
		expected.add(Position.B1);
		expected.add(Position.B2);
		assertEquals(expected, possibleMoves);
	}
	
	@Test
	public void corner2_test() {
		king.setPosition(Position.A8);
		List<Position> possibleMoves = king.getPossiblePositions(board.getRealBoard());
		List<Position> expected = new ArrayList<Position>();
		expected.add(Position.A7);
		expected.add(Position.B8);
		expected.add(Position.B7);
		assertEquals(expected, possibleMoves);
	}
	
	@Test
	public void corner3_test() {
		king.setPosition(Position.H8);
		List<Position> possibleMoves = king.getPossiblePositions(board.getRealBoard());
		List<Position> expected = new ArrayList<Position>();
		expected.add(Position.H7);
		expected.add(Position.G8);
		expected.add(Position.G7);
		assertEquals(expected, possibleMoves);
	}
	
	@Test
	public void corner4_test() {
		king.setPosition(Position.H1);
		List<Position> possibleMoves = king.getPossiblePositions(board.getRealBoard());
		List<Position> expected = new ArrayList<Position>();
		expected.add(Position.H2);
		expected.add(Position.G1);
		expected.add(Position.G2);
		assertEquals(expected, possibleMoves);
	}
	
	@Test
	public void center_test() {
		king.setPosition(Position.D4);
		List<Position> possibleMoves = king.getPossiblePositions(board.getRealBoard());
		List<Position> expected = new ArrayList<Position>();
		expected.add(Position.D3);
		expected.add(Position.D5);
		expected.add(Position.C4);
		expected.add(Position.E4);
		expected.add(Position.E5);
		expected.add(Position.C5);
		expected.add(Position.E3);
		expected.add(Position.C3);
		assertEquals(expected, possibleMoves);
	}
	
	@Test
	public void centerWithOtherPiece_test() {
		king.setPosition(Position.D4);
		List<Piece> whitePieces = new ArrayList<Piece>();
		whitePieces.add(king);
		whitePieces.add(new Pawn(Position.C3, whitePlayer));
		setBoard();
		List<Position> possibleMoves = king.getPossiblePositions(board.getRealBoard());
		List<Position> expected = new ArrayList<Position>();
		expected.add(Position.D3);
		expected.add(Position.D5);
		expected.add(Position.E4);
		expected.add(Position.E5);
		expected.add(Position.C5);
		expected.add(Position.E3);
		expected.add(Position.C3);
		assertEquals(expected, possibleMoves);
	}
	
}
