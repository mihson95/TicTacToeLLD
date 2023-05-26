package model;

public class Move {

	private Player player;
	private Cell cell;
	
	public Move(Player player, Cell cell) {
		this.player = player;
		this.cell = cell;
	}

	public Cell getCell() {
		return cell;
	}
	
	public Player getPlayer() {
		return player;
	}
	
}
