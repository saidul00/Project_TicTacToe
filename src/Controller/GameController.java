package Controller;

import Model.Game;
import Model.GameStatus;
import Model.Move;
import Model.Player;
import Service.winningStrategy.WinningStrategy;
import Service.winningStrategy.WinningStrategyFactory;
import Service.winningStrategy.WinningStrategyName;

import java.util.List;
import java.util.Map;

public class GameController {
    public Game createGame(int dimension, List<Player> players, WinningStrategyName strategyName){
        return Game.builder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategy(WinningStrategyFactory.getWinningStrategy(strategyName, dimension))
                .build();
    }
    public void displayBoard(Game game){
        game.getCurrentBoard().displayBoard();
    }
    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }
    public Move executeMove(Game game, Player player){
        return player.makeMove(game.getCurrentBoard());
    }
    public Player checkWinner(Game game, Move lastMovePlayed){
        return game.getWinningStrategy().checkWinner(game.getCurrentBoard(),lastMovePlayed);
    }
    public Game undoMove(Game game, Move lastMovePlayed){
        return null;
    }
    public Game replayGame(){
        return null;
    }
}
