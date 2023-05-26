package controller;

import java.util.List;

import exception.IllegalTicTacToeGameParametersException;
import model.Board;
import model.Cell;
import model.CellStatus;
import model.Game;
import model.Move;
import model.Player;

public class GameController {

	
	public Game createGame(int dimension, List<Player> players) throws IllegalTicTacToeGameParametersException {
		return Game.getBuilder()
				.setDimension(dimension)
				.setPlayers(players)
				.build();
	}
	
	public void displayGame(Board board) {
		int dimension = board.getDimension();
		List<List<Cell>> cells = board.getBoard();		
		for(int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (cells.get(i).get(j).getCellStatus().equals(CellStatus.EMPTY)) {
					System.out.print("|   |");
				} else {
					System.out.print("| " + cells.get(i).get(j).getSymbol() + " |");
				}
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	public boolean isValidMove(Move move, Board board) {
		return board.isValidMove(move);
	}
	
	public void makeMove(Move move, Game game) {
		game.makeMove(move);
	}
	
}
