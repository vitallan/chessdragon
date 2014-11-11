package com.allan.game;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.Color.WHITE;
import static org.fusesource.jansi.Ansi.Color.YELLOW;

import java.util.List;

import org.fusesource.jansi.Ansi.Color;

import com.allan.exception.IllegalMoveException;
import com.allan.player.Player;
import com.allan.set.BoardProxy;
import com.allan.set.Move;
import com.allan.set.PlayerSet;
import com.allan.set.Position;

public class Board {

	private Piece[][] realBoard = new Piece[8][8];
	private Player whitePlayer;
	private Player blackPlayer;
	
	public Board(Player whitePlayer, Player blackPlayer) {
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
	}
	
	public PlayerSet deployWhite() {
		PlayerSet pieces = this.deployWhitePieces();
		pieces.setWhitePlayer(true);
		return pieces;
	}

	public PlayerSet deployBlack() {
		PlayerSet pieces = this.deployBlackPieces();
		pieces.setWhitePlayer(false);
		return pieces;
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
		if (this.realBoard[nextPosition.getI()][nextPosition.getJ()] != null) {
			Piece deadPiece = this.realBoard[nextPosition.getI()][nextPosition.getJ()];
			deadPiece.setPosition(null);
			deadPiece = null;
		}
		this.setPieceInBoard(piece);
		this.sendBoardSnapshotToPlayers();
		piece.setFirstMove(false);
	}

	public void sendBoardSnapshotToPlayers() {
		this.blackPlayer.setBoard(new BoardProxy(this));
		this.whitePlayer.setBoard(new BoardProxy(this));
	}

	public Piece[][] getBoardSnapshot() {
		return this.realBoard.clone();
	}
	
	public void printBoard() {
		for (int i = 0; i < realBoard.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < realBoard[i].length; j++) {
				if (!(realBoard[i][j] == null)) {
					Color color;
					if (getPlayerOwner(i,j).equals(whitePlayer)) {
						color = WHITE;
					} else {
						color = YELLOW;
					}
					System.out.print(ansi().fg(color).a(realBoard[i][j]).reset() + " ");
				} else {
					System.out.print(ansi().fg(RED).a("(" + Position.getByPosition(i, j) + ") ").reset());
				}
			}
			System.out.print("]\n");
		}
	}
	
	private Player getPlayerOwner(int i, int j) {
		if (realBoard[i][j] != null) {
			return realBoard[i][j].getPlayerSet().getPlayer();
		} 
		return null;
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
	
	private PlayerSet deployWhitePieces() {
		PlayerSet set = new PlayerSet(whitePlayer);
		
		set.pawn_1.setPosition(Position.A2);
		set.pawn_2.setPosition(Position.B2);
		set.pawn_3.setPosition(Position.C2);
		set.pawn_4.setPosition(Position.D2);
		set.pawn_5.setPosition(Position.E2);
		set.pawn_6.setPosition(Position.F2);
		set.pawn_7.setPosition(Position.G2);
		set.pawn_8.setPosition(Position.H2); 

		set.rook_1.setPosition(Position.A1);
		set.rook_2.setPosition(Position.H1);

		set.knight_1.setPosition(Position.B1);
		set.knight_2.setPosition(Position.G1);

		set.bishop_1.setPosition(Position.C1);
		set.bishop_2.setPosition(Position.F1);

		set.queen.setPosition(Position.D1);
		set.king.setPosition(Position.E1);
		
		this.setPlayerSetInBoard(set);
		
		return set;
	}

	private PlayerSet deployBlackPieces() {
		PlayerSet set = new PlayerSet(blackPlayer);
		
		set.pawn_1.setPosition(Position.A7);
		set.pawn_2.setPosition(Position.B7);
		set.pawn_3.setPosition(Position.C7);
		set.pawn_4.setPosition(Position.D7);
		set.pawn_5.setPosition(Position.E7);
		set.pawn_6.setPosition(Position.F7);
		set.pawn_7.setPosition(Position.G7);
		set.pawn_8.setPosition(Position.H7);

		set.rook_1.setPosition(Position.A8);
		set.rook_2.setPosition(Position.H8);

		set.knight_1.setPosition(Position.B8);
		set.knight_2.setPosition(Position.G8);

		set.bishop_1.setPosition(Position.C8);
		set.bishop_2.setPosition(Position.F8);

		set.king.setPosition(Position.E8);
		set.queen.setPosition(Position.D8);
		
		this.setPlayerSetInBoard(set);

		return set;
	}

}
