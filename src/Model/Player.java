package Model;

import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private char symbol;
    private PlayerType playerType;

    public Player() {
    }

    public Player(int id, String name, char symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public Move makeMove(Board board){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the row for target cell :");
        int row = sc.nextInt();
        System.out.println("enter the column for target cell :");
        int col = sc.nextInt();

        Cell cellPlayedOn = board.getMatrix().get(row).get(col);
        cellPlayedOn.setCellState(CellState.FILLED);
        cellPlayedOn.setPlayer(this);

        return new Move(cellPlayedOn,this);
    }
}
