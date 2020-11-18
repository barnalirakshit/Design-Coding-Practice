package game.practice.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.practice.TicTacToeGame;
import game.practice.impl.TicTacToeGameImpl;
import game.practice.model.Player;

class TicTacToeGameTestCase {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

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

}
