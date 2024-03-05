package Service.winningStrategy;

public class WinningStrategyFactory {
    public WinningStrategy getWinningStrategy(WinningStrategy name, int dimension){
        return new OrderOneWinningStrategy(dimension);
    }
}
