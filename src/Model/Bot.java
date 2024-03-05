package Model;

import BotDifficultyLevel;

public class Bot extends Player{
    BotDifficultyLevel botDifficultyLevel;

    public Bot(int id, String name, char symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(id, "BB8", '%', PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        return super.makeMove(board);
    }
}
