package battleship;

import java.util.Arrays;

public class Ship extends Board{
    int[] shipLabel = new int[2];
    int[][] shipCoordinates;


    int shipHealth;

    public void placeShip(char[][] board, int cells) {
        shipHealth = cells;
        shipCoordinates = new int[cells][2];
        while (true) {
            //System.out.println("Enter the start and end coordinates of the ship (e.g. A10 A5 or F2 F6):");
            String[] input = scanner.nextLine().split(" ");
            char startRow = input[0].toUpperCase().charAt(0);
            int startCol = Integer.parseInt(input[0].substring(1)) - 1;
            char endRow = input[1].toUpperCase().charAt(0);
            int endCol = Integer.parseInt(input[1].substring(1)) - 1;
            int startRowIndex = startRow - 'A';
            int endRowIndex = endRow - 'A';
            int rowStart, rowEnd, colStart, colEnd;

            if (startRowIndex <= endRowIndex) {
                rowStart = startRowIndex;
                rowEnd = endRowIndex;
            } else {
                rowStart = endRowIndex;
                rowEnd = startRowIndex;
            }
            if (startCol <= endCol) {
                colStart = startCol;
                colEnd = endCol;
            } else {
                colStart = endCol;
                colEnd = startCol;
            }

            shipLabel[0] = rowStart;
            shipLabel[1] = colStart;

            //System.out.println(shipLabel[0]+ " "+shipLabel[1]);



            //System.out.println(rowStart+" "+rowEnd+" "+colStart+" "+colEnd);

            if (rowStart != rowEnd && colStart != colEnd) {
                System.out.println("Error! Wrong ship location! Try Again: ");
                continue;
            }


            int rowDiff = Math.abs(startRowIndex - endRowIndex) + 1;
            int colDiff = Math.abs(startCol - endCol) + 1;
            int size = Math.max(rowDiff, colDiff);

            if (size != cells) {
                System.out.println("Error! Wrong length of the Submarine! Try again: ");
                continue;
            }
            boolean isNear = false;
            for (int i = rowStart - 1; i <= rowEnd + 1; i++) {
                for (int j = colStart - 1; j <= colEnd + 1; j++) {
                    if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                        if (board[i][j] == 'O') {
                            System.out.println("Error! You placed it too close to another one. Try again: ");
                            isNear = true;
                            break;
                        }
                    }
                }
                if (isNear) {
                    break;
                }
            }

            if (isNear) {
                continue;
            }
            int index = 0;
            for (int i = rowStart; i <= rowEnd; i++) {
                for (int j = colStart; j <= colEnd; j++) {
                    board[i][j] = 'O';
                    shipCoordinates[index][0] = i;
                    shipCoordinates[index][1] = j;
                    index++;
                }
            }


            //System.out.println("Ship placed successfully!");
            break;
        }
    }
    public int[] getShipLabel() {
        return shipLabel;
    }

    public int[][] getShipCoordinates(){
        return shipCoordinates;
    }
    public void getShipHealth(){
        System.out.println(shipHealth);
    }

}


