package game.practice.model;

public class Move {

	private final Player player;
	private final int row;
	private final int col;

	public Move(Player player, int row, int col) {

		this.player = player;
		this.row = row;
		this.col = col;
	}

	public Player getPlayer() {
		return player;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

}
