
<h><b>Design a 2 player tic tac toe game.</b></h></br>
The focus of this project is on object-oriented programming.
Write test case.

Primary Requirement:
- it's a 2 player game
- One player chooses ‘O’ and the other ‘X’ to mark their respective cells
- player can only mark in empty cells
- player marks in cells in turns
- winning strategy - one players has one whole row/ column/ diagonal filled with his/her respective character (‘O’ or ‘X’).
- If no one wins(all the cells are filled), then the game is declared as draw

Secondary requirement(not implemented)
- ability to undo move
- reset the game
- save players game history
- timed game

```
public interface TicTacToeGame {

	public void play(int row, int col) throws IllegalAccessException;

	public boolean isGameOver();

	public boolean isTie();

	public Player getWinner();

}
```

```
@Test
	void testPlayer1Wins() throws IllegalAccessException {
		Player player1 = new Player("Barnali", 'X');
		Player player2 = new Player("Rakshit", '0');
		TicTacToeGame game = new TicTacToeGameImpl(player1, player2, 5);
		game.play(0, 0);// player1
		game.play(0, 1);// player2
		game.play(1, 1);// player1
		game.play(0, 2);// player2
		game.play(2, 2);// player1
		Player winner = game.getWinner();
		assertTrue(winner.getName().equals("Barnali"));
		assertTrue(game.isGameOver());
		assertFalse(game.isTie());
	}
  ```
