package strategy;

import model.Cell;
import model.Game;
import model.Player;

public interface GameWinningStrategy {

	boolean isGameWon(Game game, Player player, Cell cell);
}
