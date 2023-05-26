package strategy;

import model.Board;
import model.Cell;

public interface BotPlayingStrategy {

	public Cell botPlay(Board board);
}
