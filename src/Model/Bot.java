package Model;


import Service.BotPlayingStrategy.BotPlayingStrategy;
import Service.BotPlayingStrategy.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(int id, BotDifficultyLevel botDifficultyLevel) {
        super(id, "BB8", '%', PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        return BotPlayingStrategyFactory.getBotPlayingStrategy().makeMove(board,this);
    }
}
