package strategy;

import java.util.List;

import model.Board;
import model.Cell;
import model.Game;
import model.Player;

public class OrderNGameWinningStrategy implements GameWinningStrategy{

	@Override
	public boolean isGameWon(Game game, Player player, Cell cell) {
		Board board = game.getBoard();
		int dimension = board.getDimension();
		int row = cell.getRow();
		int col = cell.getCol();
		char symbol = player.getSymbol();
		
		if(checkRow(row,dimension,board,symbol)) {
			return true;
		} 
		
		if(checkCol(col,dimension,board,symbol)) {
			return true;
		}
		
		if(isInTopLeftDiagonal(row,col)) {
			if(checkTopLeftDiagonal(row,col,board,symbol)) {
				return true;
			}
		}		
		if(isInTopRightDiagonal(row,col,dimension)) {
			if(checkTopRightDiagonal(row,col,board,symbol)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkRow(int row, int dimension, Board board, char symbol) {	
		List<Cell> rowOfBoard = board.getBoard().get(row);
		int count = 0;
		for(int i = 0; i < dimension; i++) {
			if(symbol == rowOfBoard.get(i).getSymbol()) {
				count++;
			}
		}
		return (count == dimension);
	}
	
	private boolean checkCol(int col, int dimension, Board board, char symbol) {
		List<List<Cell>> completeBoard = board.getBoard();
		int count = 0;
		for(int i = 0; i < dimension; i++) {
			if(symbol == completeBoard.get(i).get(col).getSymbol()) {
				count++;
			}
		}		
		return (count==dimension);
	}

	private boolean isInTopLeftDiagonal(int row, int col) {
		return (row == col);
	}

	private boolean isInTopRightDiagonal(int row, int col, int dimension) {
		return (row+col == dimension-1);
	}
	
	private boolean checkTopLeftDiagonal(int row, int col, Board board, char symbol) {
		List<List<Cell>> completeBoard = board.getBoard();
		int dimension = board.getDimension();
		int count = 0;
		for(int i = 0; i < dimension; i++) {
			if(completeBoard.get(i).get(i).getSymbol() == symbol) {
				count++;
			}
		}
		return (count == dimension);
	}
	
	private boolean checkTopRightDiagonal(int row, int col, Board board, char symbol) {
		List<List<Cell>> completeBoard = board.getBoard();
		int dimension = board.getDimension();
		int count = 0;
		for(int i = 0; i < dimension; i++) {
			if(completeBoard.get(i).get(dimension-1-i).getSymbol() == symbol) {
				count++;
			}
		}
		return (count == dimension);	
	}
}
