package game.practice.model;

public class Player {

	@Override
	public String toString() {
		return "Player [name=" + name + ", tictactoeMark=" + tictactoeMark + "]";
	}

	private final String name;
	private final char tictactoeMark;
	// private GameHistory gameHistory (not supported)

	public Player(String name, char tictactoeMark) {
		this.name = name;
		this.tictactoeMark = tictactoeMark;
	}

	public String getName() {
		return name;
	}

	public char getTictactoeMark() {
		return tictactoeMark;
	}

}
