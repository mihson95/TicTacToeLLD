package strategy;

import model.Board;
import model.Cell;
import model.CellStatus;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{

	@Override
	public Cell botPlay(Board board) {
		int dimension = board.getDimension();
		for(int i = 0; i < dimension; i++) {
			for(int j = 0; j < dimension; j++) {
				if(board.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.EMPTY)) {
					return board.getBoard().get(i).get(j);
				}
			}
		}
		return null;
	}

	
}
