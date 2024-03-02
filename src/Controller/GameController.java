package Controller;

import Model.Game;
import Model.GameStatus;
import Model.Move;
import Model.Player;

import java.util.List;
import java.util.Map;

public class GameController {
    public Game createGame(int dimension, List<Player> players){
        return null;
    }
    public void displayBoard(Game game){
        game.getCurrentBoard().displayBoard();
    }
    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }
    public Player getWinner(Game game){
        return null;
    }
    public Move executeMove(Game game, Player player){
        return null;
    }
    public Player checkWinner(Game game, Move lastPlayed){
        return null;
    }
    public Game undoMove(Game game, Move lastPlayed){
        return null;
    }
    public Game replayGame(){
        return null;
    }
}
