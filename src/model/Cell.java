package model;

public class Cell {

	private int row;
	private int col;
	private CellStatus cellStatus;
	private char symbol;
	
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		this.cellStatus = CellStatus.EMPTY;
	}

	public CellStatus getCellStatus() {
		return cellStatus;
	}

	public void setCellStatus(CellStatus cellStatus) {
		this.cellStatus = cellStatus;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
}
