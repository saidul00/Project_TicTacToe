package Service.BotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(){
        return  new RandomBotPlayingStrategy();
    }
}
