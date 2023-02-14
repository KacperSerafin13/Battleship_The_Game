package battleship;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Board {

    int occupiedCells = 17;
    public char[][] board = new char[10][10];

    public char[][] fogBoard = new char[10][10];

    Scanner scanner = new Scanner(System.in);



    public Board() {
    }

    public void initBoard() {
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '~');
        }
    }

    public void displayBoard() {
        char[] columns = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        System.out.print("  ");
        for (int i = 1; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.print("1" + columns[9]);
        System.out.println();
        char[] rows = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        for (int i = 0; i < board.length; i++) {
            System.out.print(rows[i] + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void initFogBoard() {
        for (int i = 0; i < fogBoard.length; i++) {
            Arrays.fill(fogBoard[i], '~');
        }
    }

    public void displayFogBoard() {
        char[] columns = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        System.out.print("  ");
        for (int i = 1; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.print("1" + columns[9]);
        System.out.println();
        char[] rows = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        for (int i = 0; i < fogBoard.length; i++) {
            System.out.print(rows[i] + " ");
            for (int j = 0; j < fogBoard[i].length; j++) {
                System.out.print(fogBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

}
