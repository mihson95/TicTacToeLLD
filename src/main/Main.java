package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.GameController;
import exception.IllegalTicTacToeGameParametersException;
import model.Bot;
import model.Cell;
import model.Game;
import model.GameStatus;
import model.Move;
import model.Player;
import model.PlayerType;

public class Main {
		
	public static void main(String[] args) throws IllegalTicTacToeGameParametersException {
		GameController gameController = new GameController();
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the board dimensions?");
		int dimension = sc.nextInt();
		
		System.out.println("Is there a bot player? (y/n)");
		String isBotPlayerPresent = sc.next();

		List<Player> players = new ArrayList<Player>();
		
		int numberOfHumanPlayers = dimension - 1;
		if(isBotPlayerPresent.equals("y")) {
			numberOfHumanPlayers-=1;
			players.add(new Bot("BOT1", '$'));
		}
		for(int i = 0; i < numberOfHumanPlayers; i++) {
			System.out.println("What is name of player "+i);
			String name = sc.next();
			System.out.println("What is the symbol of this player?");
			String symbol = sc.next();
			players.add(new Player(name, symbol.charAt(0), PlayerType.HUMAN));
		}
		
		Game game = gameController.createGame(dimension, players);
		
		while(game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
			gameController.displayGame(game.getBoard());
			int index = game.getNextPlayerIndex();
			Player player = players.get(index);
			System.out.println(player.getName()+"'s turn: ");
			Cell cell = null;
			if(player.getPlayerType().equals(PlayerType.BOT)) {
				Bot bot = (Bot)player;
				cell = bot.getBotPlayingStrategy().botPlay(game.getBoard());
			}
			else {
				System.out.println("Enter the row to play.");
				int row = sc.nextInt();
				
				System.out.println("Enter the col to play.");
				int col = sc.nextInt();
				
				cell = new Cell(row, col);
				
			}
			Move move = new Move(player, cell);
			
			if(gameController.isValidMove(move,game.getBoard())) {
				gameController.makeMove(move, game);
			}
			else {
				
				while(true) {
					System.out.println("Make Valid Move. Enter the row to play.");
					int row = sc.nextInt();
					
					System.out.println("Enter the col to play.");
					int col = sc.nextInt();
					
					move = new Move(player, new Cell(row, col));
					if(gameController.isValidMove(move,game.getBoard())) {
						gameController.makeMove(move, game);
						break;
					}
				}
			}
			
			if(game.getGameWinningStrategy().isGameWon(game, player, cell)) {
				System.out.println("Player: "+player.getName()+" has won!");
				game.setGameStatus(GameStatus.COMPLETED);
				gameController.displayGame(game.getBoard());
			}
			
			if(game.getMoves().size() == dimension*dimension) {
				System.out.println("Game is drawn.");
				game.setGameStatus(GameStatus.DRAW);
				gameController.displayGame(game.getBoard());
			}
			index++;
			index %= players.size();
			game.setNextPlayerIndex(index);
			
		}
		sc.close();
	}

}
