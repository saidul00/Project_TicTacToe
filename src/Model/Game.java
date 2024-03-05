package Model;

import Eceptions.InvalidNumberOfBotException;
import Eceptions.InvalidPlayerException;
import Eceptions.InvalidSymbolException;
import Service.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board currentBoard;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private List<Move> moves;
    private List<Board> boardsStates;
    private WinningStrategy winningStrategy;
    private int symbols;


    private Game(Board currentBoard, List<Player> players, WinningStrategy winningStrategy) {
        this.currentBoard = currentBoard;
        this.players = players;
        this.currentPlayer = null;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.boardsStates = new ArrayList<>();
        this.winningStrategy = winningStrategy;
        this.symbols = players.size();
    }
    public static Builder builder(){
        return new Builder();
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<Board> getBoardsStates() {
        return boardsStates;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public int getSymbols() {
        return symbols;
    }

    public static class Builder{
        private Board currentBoard;
        private List<Player> players;
        private WinningStrategy winningStrategy;
        private int dimension;


        public Builder setCurrentBoard(Board currentBoard) {
            this.currentBoard = currentBoard;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }


        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }


        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        private void validatePlayer(){

            if(players.size() >= dimension || players.size() < dimension-2){
                throw new InvalidPlayerException("Invalid number of players in the Game.");
            }
        }
        public void validateSymbols(){
            HashSet<Character> symbols = new HashSet<>();
            for(Player player : players){
                symbols.add(player.getSymbol());
            }
            if(symbols.size() != players.size()){
                throw new InvalidSymbolException("Every player should choose unique symbol");
            }
        }
        public void validateBot(){
            int botCount = 0;
            for(Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }
            if(botCount > 1 || botCount < 0){
                throw new InvalidNumberOfBotException("Only one Bot is allowed in a Game");
            }
        }
        public void validate(){
            validatePlayer();
            validateSymbols();
            validateBot();
        }
        public Game build(){
            validate();
            return new Game((new Board(dimension)),players, winningStrategy);
        }
    }
}
