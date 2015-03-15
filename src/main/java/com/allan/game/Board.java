package com.allan.game;

import java.util.ArrayList;
import java.util.List;

import com.allan.exception.IllegalMoveException;
import com.allan.piece.Bishop;
import com.allan.piece.King;
import com.allan.piece.Knight;
import com.allan.piece.Pawn;
import com.allan.piece.Queen;
import com.allan.piece.Rook;
import com.allan.player.Player;
import com.allan.set.Move;
import com.allan.set.Position;
import com.allan.util.Utils;

public class Board {

	private Piece[][] realBoard;
	private List<Piece> whiteSet;
	private List<Piece> blackSet;
	private Player whitePlayer;
	private Player blackPlayer;
	
	public Board(Player playerWhite, Player playerBlack) {
		realBoard = new Piece[8][8];
		
		this.whitePlayer = playerWhite;
		this.blackPlayer = playerBlack;
		
		this.buildWhiteSet();
		this.buildBlackSet();
		
		this.whitePlayer.setPieces(whiteSet);
		this.blackPlayer.setPieces(blackSet);
		
		this.blackPlayer.setMovesUp(true);
		this.whitePlayer.setMovesUp(false);
	}
	
	public Piece[][] getRealBoard() {
		return this.realBoard.clone();
	}
	
	private void buildBlackSet() {
		Position[] positions = new Position[16];
		
		positions[0] = Position.E1;
		positions[1] = Position.D1;
		positions[2] = Position.A1;
		positions[3] = Position.H1;
		positions[4] = Position.B1;
		positions[5] = Position.G1;
		positions[6] = Position.F1;
		positions[7] = Position.C1;
		
		positions[8] = Position.A2;
		positions[9] = Position.H2;
		positions[10] = Position.B2;
		positions[11] = Position.G2;
		positions[12] = Position.C2;
		positions[13] = Position.F2;
		positions[14] = Position.D2;
		positions[15] = Position.E2;
		
		this.blackSet = createPieces(positions, blackPlayer);
	}

	private void buildWhiteSet() {
		Position[] positions = new Position[16];
		
		positions[0] = Position.E8;
		positions[1] = Position.D8;
		positions[2] = Position.A8;
		positions[3] = Position.H8;
		positions[4] = Position.B8;
		positions[5] = Position.G8;
		positions[6] = Position.F8;
		positions[7] = Position.C8;
		
		positions[8] = Position.A7;
		positions[9] = Position.H7;
		positions[10] = Position.B7;
		positions[11] = Position.G7;
		positions[12] = Position.C7;
		positions[13] = Position.F7;
		positions[14] = Position.D7;
		positions[15] = Position.E7;
		
		this.whiteSet = createPieces(positions, whitePlayer);
	}
	
	private List<Piece> createPieces(Position[] position, Player player) {
		List<Piece> pieces = new ArrayList<Piece>();
		//how can i refactor this?
		Piece piece = new King(position[0], player);
		pieces.add(piece);
		piece = new Queen(position[1], player);
		pieces.add(piece);
		piece = new Rook(position[2], player);
		pieces.add(piece);
		piece = new Rook(position[3], player);
		pieces.add(piece);
		piece = new Knight(position[4], player);
		pieces.add(piece);
		piece = new Knight(position[5], player);
		pieces.add(piece);
		piece = new Bishop(position[6], player);
		pieces.add(piece);
		piece = new Bishop(position[7], player);
		pieces.add(piece);
		piece = new Pawn(position[8], player);
		pieces.add(piece);
		piece = new Pawn(position[9], player);
		pieces.add(piece);
		piece = new Pawn(position[10], player);
		pieces.add(piece);
		piece = new Pawn(position[11], player);
		pieces.add(piece);
		piece = new Pawn(position[12], player);
		pieces.add(piece);
		piece = new Pawn(position[13], player);
		pieces.add(piece);
		piece = new Pawn(position[14], player);
		pieces.add(piece);
		piece = new Pawn(position[15], player);
		pieces.add(piece);
		for (Piece toSet : pieces) {
			this.setPieceInBoard(toSet);
		}
		return pieces;
	}
	
	private void setPieceInBoard(Piece piece) {
		realBoard[piece.getI()][piece.getJ()] = piece;
	}
	
	public void move(Move move) throws IllegalMoveException {
		Piece piece = move.getPiece();
		Position nextPosition = move.getFuturePosition();
		Position currentPosition = piece.getPosition();
		if (!piece.getPossibleMoves(this.realBoard).contains(nextPosition)) {
			throw new IllegalMoveException("[ " + piece.getAbbreviation() + " in " + currentPosition + "] Cant go to " + nextPosition );
		}
		realBoard[currentPosition.getI()][currentPosition.getJ()] = null;
		piece.setPosition(nextPosition); 
		killPiece(nextPosition);
		piece.setPosition(nextPosition); //just to make sure
		this.setPieceInBoard(piece);
		piece.setFirstMove(false);
	}

	private void killPiece(Position position) {
		Piece deadPiece = this.realBoard[position.getI()][position.getJ()];
		if (deadPiece != null) {
			deadPiece.setPosition(null);
			deadPiece = null;
		}
	}
	
	public void printBoard() {
		Utils.printBoard(realBoard, whitePlayer); //i send the player just for coloring purposes
	}
	
}
