package Service.winningStrategy;

import Model.Board;
import Model.Move;
import Model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy {
    private int dimension;
    private List<HashMap<Character, Integer>> rowHashMaps;
    private List<HashMap<Character, Integer>> colHashMaps;
    private HashMap<Character, Integer> leftDiagnalHashMap;
    private HashMap<Character, Integer> rightDiagnalHashMap;
    private HashMap<Character, Integer> cornersHashMap;


    public OrderOneWinningStrategy(int dimension) {
        this.dimension = dimension;
        rowHashMaps = new ArrayList<>();
        colHashMaps = new ArrayList<>();
        leftDiagnalHashMap = new HashMap<>();
        rightDiagnalHashMap = new HashMap<>();
        cornersHashMap = new HashMap<>();
        for(int i=0;i<dimension;i++){
            rowHashMaps.add(new HashMap<>());
            colHashMaps.add(new HashMap<>());
        }
    }

    @Override
    public Player checkWinner(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        char symbol = player.getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        boolean winnerResult = (checkCorners(row,col) && cornersWinnerChecker(symbol)
                || checkLeftDiagonal(row,col) && leftDiagonalWinnerChecker(symbol)
                || checkRightDiagonal(row, col) && rightDiagonalWinnerChecker(symbol)
                || rowWinnerChecker(row,symbol)
                || colWinnerChecker(col, symbol)
        );
        if(winnerResult){
            return player;
        }else{
            return null;
        }


    }
    private boolean checkLeftDiagonal(int row , int col){
        return (row == col);
    }

    private boolean checkRightDiagonal(int row, int col){
        return ((row + col) == (dimension-1));
    }

    private boolean checkCorners(int row, int col){
        return ((row == 0 && col == 0)
                || (row == 0 && col==dimension-1)
                || (row == dimension-1 && col == 0)
                || (row == dimension -1 && col == dimension -1)
        );
    }
    private boolean rowWinnerChecker(int row, char symbol){
        HashMap<Character , Integer> rowHashMap= rowHashMaps.get(row);
        if(rowHashMap.containsKey(symbol)){
            rowHashMap.put(symbol, rowHashMap.get(symbol)+1);
            return rowHashMap.get(symbol) == dimension;
        }else{
            rowHashMap.put(symbol, 1);
        }
        return false;
    }
    private boolean colWinnerChecker(int col, char symbol){
        HashMap<Character, Integer> columnHashmap = colHashMaps.get(col);
        if(columnHashmap.containsKey(symbol)){
            columnHashmap.put(symbol, columnHashmap.get(symbol)+1);
            return columnHashmap.get(symbol) == dimension;
        }else{
            columnHashmap.put(symbol,1);
        }
        return false;
    }
    private boolean leftDiagonalWinnerChecker(char symbol){
        if(leftDiagnalHashMap.containsKey(symbol)){
            leftDiagnalHashMap.put(symbol, leftDiagnalHashMap.get(symbol)+1);
            return leftDiagnalHashMap.get(symbol) == dimension;
        }else {
            leftDiagnalHashMap.put(symbol,1);
        }
        return false;
    }
    private boolean rightDiagonalWinnerChecker(char symbol){
        if(rightDiagnalHashMap.containsKey(symbol)){
            rightDiagnalHashMap.put(symbol, rightDiagnalHashMap.get(symbol)+1);
            return rightDiagnalHashMap.get(symbol) == dimension;
        }else {
            rightDiagnalHashMap.put(symbol,1);
        }
        return false;
    }

    private boolean cornersWinnerChecker(char symbol){
        if(cornersHashMap.containsKey(symbol)){
            cornersHashMap.put(symbol, cornersHashMap.get(symbol)+1);
            return cornersHashMap.get(symbol) == 4;
        }else{
            cornersHashMap.put(symbol,1);
        }
        return false;
    }
}
