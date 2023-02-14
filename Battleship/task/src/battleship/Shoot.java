package battleship;


public class Shoot extends Ship {
    int[][] shipCoordinates1;
    int[][] shipCoordinates2;
    int[][] shipCoordinates3;
    int[][] shipCoordinates4;
    int[][] shipCoordinates5;

    int[][] shipCoordinates10;
    int[][] shipCoordinates6;
    int[][] shipCoordinates7;
    int[][] shipCoordinates8;
    int[][] shipCoordinates9;

    boolean allShipsSunk2 = false;

    boolean allShipsSunk1 = false;


    public Shoot() {

    }


    public void shootMissile(char[][] board) {
        initBoard();
        initFogBoard();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].length() == 0) {
                System.out.println("Error! You entered an empty string. Try Again: ");
                continue;
            }
            char Row = input[0].toUpperCase().charAt(0);

            if (input[0].length() < 2) {
                System.out.println("Error! You entered the wrong coordinates! Try Again: ");
                continue;
            }
            int Column = Integer.parseInt(input[0].substring(1)) - 1;


            if (Column < 0 || Column > board[0].length) {
                System.out.println("Error! You entered the wrong coordinates! Try Again:  ");
                continue;
            }

            int startRowIndex = Row - 'A';

            //System.out.println(Row + Column);
            if (startRowIndex >= 10) {
                System.out.println("Error! You entered the wrong coordinates! Try Again: ");
                continue;
            }


            //System.out.println(occupiedCells);

            if (board[startRowIndex][Column] == 'O') {
                board[startRowIndex][Column] = 'X';
                System.out.println("You hit a ship!");
                break;
            } else if (board[startRowIndex][Column] == '~') {
                System.out.println("You missed!");
                board[startRowIndex][Column] = 'M';
                break;
            } else if (board[startRowIndex][Column] == 'X') {
                System.out.println("This coordinate was already shooted");
                break;
            } else if (board[startRowIndex][Column] == 'M') {
                System.out.println("This coordinate was already missed");
                break;
            }
        }
    }


    public void checkIfShipPlayer2Sunk(char[][] board) {
        shipCoordinates1 = Main.player1_ship1.getShipCoordinates();
        shipCoordinates2 = Main.player1_ship2.getShipCoordinates();
        shipCoordinates3 = Main.player1_ship3.getShipCoordinates();
        shipCoordinates4 = Main.player1_ship4.getShipCoordinates();
        shipCoordinates5 = Main.player1_ship5.getShipCoordinates();

        int[][][] player2ShipsCoordinates = {shipCoordinates1, shipCoordinates2, shipCoordinates3, shipCoordinates4, shipCoordinates5};
        boolean[] player2ShipsSunk = {false, false, false, false, false};

        for (int i = 0; i < player2ShipsCoordinates.length; i++) {
            int[][] shipCoordinates = player2ShipsCoordinates[i];

            boolean allCoordsHit = true;

            for (int[] coords : shipCoordinates) {
                int row = coords[0];
                int column = coords[1];

                if (board[row][column] != 'X') {
                    allCoordsHit = false;
                    break;
                }
            }

            if (allCoordsHit) {
                player2ShipsSunk[i] = true;
                System.out.println("You sank a ship!");
            }
        }

        allShipsSunk2 = true;
        for (boolean shipSunk : player2ShipsSunk) {
            if (!shipSunk) {
                allShipsSunk2 = false;
                break;
            }
        }

        if (allShipsSunk2) {
            System.out.println("You sunk all ships! Game over.");
        }
    }

    public void checkIfShipPlayer1Sunk(char[][] board) {
        shipCoordinates6 = Main.player2_ship1.getShipCoordinates();
        shipCoordinates7 = Main.player2_ship2.getShipCoordinates();
        shipCoordinates8 = Main.player2_ship3.getShipCoordinates();
        shipCoordinates9 = Main.player2_ship4.getShipCoordinates();
        shipCoordinates10 = Main.player2_ship5.getShipCoordinates();

        int[][][] player2ShipsCoordinates = {shipCoordinates6, shipCoordinates7, shipCoordinates8, shipCoordinates9, shipCoordinates10};
        boolean[] player2ShipsSunk = {false, false, false, false, false};

        for (int i = 0; i < player2ShipsCoordinates.length; i++) {
            int[][] shipCoordinates = player2ShipsCoordinates[i];

            boolean allCoordsHit = true;

            for (int[] coords : shipCoordinates) {
                int row = coords[0];
                int column = coords[1];

                if (board[row][column] != 'X') {
                    allCoordsHit = false;
                    break;
                }
            }

            if (allCoordsHit) {
                player2ShipsSunk[i] = true;
                System.out.println("You sank a ship!");
            }
        }

        allShipsSunk1 = true;
        for (boolean shipSunk : player2ShipsSunk) {
            if (!shipSunk) {
                allShipsSunk1 = false;
                break;
            }
        }

        if (allShipsSunk1) {
            System.out.println("You sunk all ships! Game over.");
        }
    }




}


