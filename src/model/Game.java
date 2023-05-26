package model;

import java.util.ArrayList;
import java.util.List;

import exception.IllegalTicTacToeGameParametersException;
import strategy.GameWinningStrategy;
import strategy.OrderNGameWinningStrategy;

public class Game {

	private Board board;
	private List<Player> players;
	private List<Move> moves;
	private GameStatus gameStatus;
	private int nextPlayerIndex;
	private GameWinningStrategy gameWinningStrategy;
	
	public GameWinningStrategy getGameWinningStrategy() {
		return gameWinningStrategy;
	}

	public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
		this.gameWinningStrategy = gameWinningStrategy;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	public int getNextPlayerIndex() {
		return nextPlayerIndex;
	}

	public void setNextPlayerIndex(int nextPlayerIndex) {
		this.nextPlayerIndex = nextPlayerIndex;
	}

	private Game() {}
	
	public static Builder getBuilder() {
		return new Builder();
	}
	
	public static class Builder {
		
		private int dimension;
		private List<Player> players;
		
		public Builder setDimension(int dimension) {
			this.dimension = dimension;
			return this;
		}
		public Builder setPlayers(List<Player> players) {
			this.players = players;
			return this;
		}
		
		public boolean valid() throws IllegalTicTacToeGameParametersException {
			if(dimension < 3) {
				throw new IllegalTicTacToeGameParametersException("incorrect dimensions for game.");
			}
			if(players.size()>= dimension) {
				throw new IllegalTicTacToeGameParametersException("incorrect number of players.");
			}
			
			return true;
		}
		
		public Game build() throws IllegalTicTacToeGameParametersException {
			try {
				valid();
			}
			catch(IllegalTicTacToeGameParametersException e) {
				throw e;
			}
			
			Game game = new Game();
			game.setBoard(new Board(dimension));
			game.setPlayers(players);
			game.setMoves(new ArrayList<Move>());
			game.setGameStatus(GameStatus.IN_PROGRESS);
			game.setNextPlayerIndex(0);
			game.setGameWinningStrategy(new OrderNGameWinningStrategy());
			
			return game;
		}
		
		
	}

	public void makeMove(Move move) {
		Cell cell = move.getCell();
		Player player = move.getPlayer();
		int row = cell.getRow();
		int col = cell.getCol();
		
		this.board.getBoard().get(row).get(col).setSymbol(player.getSymbol());
		this.board.getBoard().get(row).get(col).setCellStatus(CellStatus.FILLED);;
		this.moves.add(move);
	}
}
