package model;

import strategy.BotPlayingStrategy;
import strategy.RandomBotPlayingStrategy;

public class Bot extends Player{

	BotPlayingStrategy botPlayingStrategy;
	
	public Bot(String name, char symbol) {
		super(name, symbol, PlayerType.BOT);
		this.botPlayingStrategy = new RandomBotPlayingStrategy();
	}

	public BotPlayingStrategy getBotPlayingStrategy() {
		return botPlayingStrategy;
	}

	public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
		this.botPlayingStrategy = botPlayingStrategy;
	}

	
	
}
