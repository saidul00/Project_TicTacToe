import Controller.GameController;
import Model.*;
import Service.winningStrategy.WinningStrategyName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        int id = 1;
        List<Player> players = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe");

        System.out.println("Please Enter The Dimension of the Board");

        int dimension = sc.nextInt();
        System.out.println("Do you want Bot in the game ? Y or N ");
        String botAns = sc.next();

        if(botAns.equalsIgnoreCase("Y")){
            Player bot = new Bot(id++, BotDifficultyLevel.HARD);
            players.add(bot);
        }

        while (id < dimension){
            System.out.println("Please enter Player name :");
            String playerName = sc.next();
            System.out.println("Please enter Player's symbol :");
            char symbol = sc.next().charAt(0);
            Player Player = new Player(id++, playerName, symbol, PlayerType.HUMAN);
            players.add(Player);
        }
        Collections.shuffle(players);

        Game game = gameController.createGame(dimension,players, WinningStrategyName.ORDERONEWINNINGSTRATEGY);
        int turnIndex = -1;
        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            System.out.println("Current board state :");
            gameController.displayBoard(game);
            turnIndex++;
            turnIndex = turnIndex % players.size();
            Move movePlayed = gameController.executeMove(game, players.get(turnIndex));
            game.getMoves().add(movePlayed);
            game.getBoardsStates().add(game.getCurrentBoard());
            Player winner = gameController.checkWinner(game, movePlayed);
            if(winner != null){
                System.out.println("Winner is " + winner.getName());
                break;
            }
            if(game.getMoves().size() == (dimension * dimension)){
                System.out.println("Game is Draw");
                break;
            }
        }
        System.out.println("Final Board Status");
        gameController.displayBoard(game);
        System.out.println("Do you want to replay ?");
    }
}
