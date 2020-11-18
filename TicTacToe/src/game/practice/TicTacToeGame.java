package game.practice;

import game.practice.model.Player;

public interface TicTacToeGame {

	public void play(int row, int col) throws IllegalAccessException;

	public boolean isGameOver();

	public boolean isTie();

	public Player getWinner();

}
