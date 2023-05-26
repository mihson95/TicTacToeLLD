package model;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<List<Cell>> board = new ArrayList<List<Cell>>();
	
	private int dimension;
	
	public Board(int dimension) {
		this.dimension = dimension;
		for(int i = 0; i < this.dimension; i++) {
			List<Cell> row = new ArrayList<Cell>();
			for(int j = 0; j < this.dimension; j++) {
				Cell cell = new Cell(i, j);
				row.add(cell);
			}
			board.add(row);
		}
	}

	public List<List<Cell>> getBoard() {
		return board;
	}

	public int getDimension() {
		return dimension;
	}

	public boolean isValidMove(Move move) {
		int row = move.getCell().getRow();
		int col = move.getCell().getCol();
		
		if(this.board.get(row).get(col).getCellStatus().equals(CellStatus.EMPTY)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
