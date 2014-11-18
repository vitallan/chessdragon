package com.allan.game;

import java.util.List;

import com.allan.exception.IllegalMoveException;
import com.allan.player.Player;
import com.allan.set.BoardProxy;
import com.allan.set.Move;
import com.allan.set.PlayerSet;
import com.allan.set.Position;
import com.allan.util.Utils;

public class Board {

	private Piece[][] realBoard;
	private PlayerSet whiteSet;
	private PlayerSet blackSet;
	
	public Board(Player playerWhite, Player playerBlack) {
		realBoard = new Piece[8][8];
		whiteSet = new PlayerSet(playerWhite);
		blackSet = new PlayerSet(playerBlack);
		playerBlack.setPieces(this.deployBlack());
		playerWhite.setPieces(this.deployWhite());
		this.sendBoardSnapshotToPlayers();
	}
	
	public PlayerSet deployWhite() {
		this.deployWhitePieces();
		whiteSet.setWhitePlayer(true);
		return whiteSet;
	}

	public PlayerSet deployBlack() {
		this.deployBlackPieces();
		blackSet.setWhitePlayer(false);
		return blackSet;
	}

	public void move(Move move) throws IllegalMoveException {
		Piece piece = move.getPiece();
		Position nextPosition = move.getFuturePosition();
		Position currentPosition = piece.getPosition();
		if (!piece.getPossibleMoves(this.realBoard).contains(nextPosition)) {
			throw new IllegalMoveException("[ " + piece.getAbbreviation() + " in " + currentPosition + "] Cant go to " + nextPosition );
		}
		realBoard[currentPosition.getI()][currentPosition.getJ()] = null;
		piece.setPosition(nextPosition); //just to make sure
		Piece deadPiece = this.realBoard[nextPosition.getI()][nextPosition.getJ()];
		if (deadPiece != null) {
			deadPiece.setPosition(null);
			deadPiece = null;
		}
		this.setPieceInBoard(piece);
		this.sendBoardSnapshotToPlayers();
		piece.setFirstMove(false);
	}

	public void sendBoardSnapshotToPlayers() {
		this.blackPlayer().setBoard(new BoardProxy(this));
		this.whitePlayer().setBoard(new BoardProxy(this));
	}

	public Piece[][] getBoardSnapshot() {
		return this.realBoard.clone();
	}
	
	public void printBoard() {
		Utils.printBoard(realBoard, this.whitePlayer()); //i send the player just for coloring purposes
	}
	
	private void setPlayerSetInBoard(PlayerSet set) {
		List<Piece> playerPieces = set.getPiecesAsList();
		for (Piece piece : playerPieces) {
			this.setPieceInBoard(piece);
		}
	}
	
	private void setPieceInBoard(Piece piece) {
		Position position = piece.getPosition();
		this.realBoard[position.getI()][position.getJ()] = piece;
	}
	
	private void deployWhitePieces() {
		Position[] positions = new Position[16];
		
		positions[0] = Position.A2;
		positions[1] = Position.B2;
		positions[2] = Position.C2;
		positions[3] = Position.D2;
		positions[4] = Position.E2;
		positions[5] = Position.F2;
		positions[6] = Position.G2;
		positions[7] = Position.H2;
		
		positions[8] = Position.A1;
		positions[9] = Position.H1;
		positions[10] = Position.B1;
		positions[11] = Position.G1;
		positions[12] = Position.C1;
		positions[13] = Position.F1;
		positions[14] = Position.D1;
		positions[15] = Position.E1;
		
		deployPieces(positions, whiteSet);

	}

	private void  deployBlackPieces() {
		Position[] positions = new Position[16];
		
		positions[0] = Position.A7;
		positions[1] = Position.B7;
		positions[2] = Position.C7;
		positions[3] = Position.D7;
		positions[4] = Position.E7;
		positions[5] = Position.F7;
		positions[6] = Position.G7;
		positions[7] = Position.H7;

		positions[8] = Position.A8;
		positions[9] = Position.H8;
		positions[10] = Position.B8;
		positions[11] = Position.G8;
		positions[12] = Position.C8;
		positions[13] = Position.F8;
		positions[14] = Position.D8;
		positions[15] = Position.E8;
		
		deployPieces(positions, blackSet);

	}
	
	public void deployPieces(Position[] positions, PlayerSet set) {
		Utils.setPiecesPosition(positions, set);
		this.setPlayerSetInBoard(set);
	}
	
	private Player whitePlayer() {
		return this.whiteSet.getPlayer();
	}
	
	private Player blackPlayer() {
		return this.blackSet.getPlayer();
	}

}
