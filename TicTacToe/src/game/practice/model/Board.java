package game.practice.model;

public class Board {
	int[][] cells;
	int cellOccupied = 0;

	public Board(int n) {
		cells = new int[n][n];
	}

	public boolean hasEmptyCell() {
		return cellOccupied != (cells.length*cells.length);
	}

	public boolean makeMove(Move move) throws IllegalAccessException {
		if (cellOccupied == (cells.length*cells.length))
			throw new IllegalAccessException("Game Over");
		cellOccupied++;
		int value = move.getPlayer().getTictactoeMark() == 'X' ? 1 : -1;
		cells[move.getRow()][move.getCol()] = value;
		boolean winRow = true, winCol = true, winDiag = true, winRevDiag = true;
		for (int i = 0; i < move.getRow(); i++) {
			if (cells[move.getRow()][i] != value)
				winRow = false;
			if (cells[i][move.getCol()] != value)
				winCol = false;
			if (cells[i][i] != value)
				winDiag = false;
			if (cells[i][cells.length - 1 - i] != value)
				winRevDiag = false;
		}
		return (winRow || winCol || winDiag || winRevDiag);

	}

}
