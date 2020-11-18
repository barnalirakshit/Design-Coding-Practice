package game.practice.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import game.practice.TicTacToeGame;
import game.practice.model.Board;
import game.practice.model.Move;
import game.practice.model.Player;

public class TicTacToeGameImpl implements TicTacToeGame {

	private String gameId;
	private Player firstPlayer;
	private Player secondPlayer;
	private Player currentPlayer;
	private Player winnerPlayer;
	private Board board;
	private List<Move> gameMoves; // could be used for undo- not implemented. We could use mememto pattern for
									// undo(https://www.journaldev.com/1734/memento-design-pattern-java)

	public TicTacToeGameImpl(Player firstPlayer, Player secondPlayer, int sizeOfBorad) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.board = new Board(sizeOfBorad);
		gameId = UUID.randomUUID().toString();
		gameMoves = new ArrayList<>();
	}

	@Override
	public void play(int row, int col) throws IllegalAccessException {
		if (currentPlayer == null)
			currentPlayer = firstPlayer;
		Move move = new Move(currentPlayer, row, col);
		boolean win = board.makeMove(move);
		if (win)
			winnerPlayer = currentPlayer;
		gameMoves.add(move);
		currentPlayer = (currentPlayer == firstPlayer) ? secondPlayer : firstPlayer;
	}

	@Override
	public String toString() {
		return "TicTacToeGameImpl [gameId=" + gameId + ", firstPlayer=" + firstPlayer + ", secondPlayer=" + secondPlayer
				+ "]";
	}

	@Override
	public boolean isGameOver() {
		return !board.hasEmptyCell() || (winnerPlayer != null);
	}

	@Override
	public boolean isTie() {
		return (winnerPlayer == null) && !board.hasEmptyCell();
	}

	@Override
	public Player getWinner() {
		return winnerPlayer;
	}

}
