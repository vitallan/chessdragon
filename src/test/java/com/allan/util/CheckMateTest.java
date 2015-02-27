package com.allan.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.allan.game.Piece;
import com.allan.player.Player;
import com.allan.player.PlayerZero;
import com.allan.set.PlayerSet;
import com.allan.set.Position;

public class CheckMateTest {

	private Piece[][] realBoard;
	private PlayerSet agressingPlayer;
	private PlayerSet isInCheck;
	private Player white;
	private Player black;
	
	@Before
	public void setup() {
		realBoard = new Piece[8][8];
		white = new PlayerZero();
		black = new PlayerZero();
		agressingPlayer = new PlayerSet(white);
		isInCheck = new PlayerSet(black);
		
		Position kingPosition = Position.A3;
		isInCheck.king.setPosition(kingPosition);
		realBoard[kingPosition.getI()][kingPosition.getJ()] = isInCheck.king;
	}

	@Test
	public void rookCheckTest() {
		setPiece(agressingPlayer.rook_1, Position.A1);
		List<Piece> pieces = Utils.isKingInCheck(agressingPlayer, isInCheck, realBoard);
		assertEquals(pieces.size(), 1);
	}
	
	@Test
	public void rookEscapeCheckMate() {
		setPiece(agressingPlayer.queen, Position.A2);
		assertFalse(Utils.isKingInCheckMate(agressingPlayer, isInCheck, realBoard));
	}
	
	@Test
	public void captureCheckerPiece() {
		setPiece(agressingPlayer.rook_1, Position.A1);
		setPiece(agressingPlayer.rook_2, Position.B1);
		setPiece(isInCheck.queen, Position.D4);
		assertFalse(Utils.isKingInCheckMate(agressingPlayer, isInCheck, realBoard));
	}
	
	@Test
	public void blockedAttackingPiece() {
		setPiece(agressingPlayer.rook_1, Position.A1);
		setPiece(agressingPlayer.rook_2, Position.B1);
		setPiece(isInCheck.rook_1, Position.A2);
		assertEquals(Utils.isKingInCheck(agressingPlayer, isInCheck, realBoard).size(), 0);
	}
	
	//@Test
	public void blockAttackingPiece() {
		setPiece(agressingPlayer.rook_1, Position.A1);
		setPiece(agressingPlayer.rook_2, Position.B1);
		setPiece(isInCheck.rook_1, Position.D2);
		assertFalse(Utils.isKingInCheckMate(agressingPlayer, isInCheck, realBoard));
	}
	
	public void setPiece(Piece piece, Position position) {
		piece.setPosition(position);
		realBoard[position.getI()][position.getJ()] = piece;
	}
}
