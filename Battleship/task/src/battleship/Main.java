package battleship;

import java.io.IOException;


public class Main {
    public static Ship player1_ship1;
    public static Ship player1_ship2;
    public static Ship player1_ship3;
    public static Ship player1_ship4;
    public static Ship player1_ship5;
    public static Ship player2_ship1;
    public static Ship player2_ship2;
    public static Ship player2_ship3;
    public static Ship player2_ship4;
    public static Ship player2_ship5;



    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        player1_ship1 = new Ship();
        player1_ship2 = new Ship();
        player1_ship3 = new Ship();
        player1_ship4 = new Ship();
        player1_ship5 = new Ship();
        player2_ship1 = new Ship();
        player2_ship2 = new Ship();
        player2_ship3 = new Ship();
        player2_ship4 = new Ship();
        player2_ship5 = new Ship();
        Board boardP1 = new Board();
        Board boardP2 = new Board();
        Shoot shootP1 = new Shoot();
        Shoot shootP2 = new Shoot();
        boardP1.initBoard();
        boardP1.initFogBoard();
        boardP2.initBoard();
        boardP2.initFogBoard();


        System.out.println("Player 1, place your ships on the game field");
        boardP1.displayBoard();
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells): ");
        player1_ship1.placeShip(boardP1.board, 5);
        boardP1.displayBoard();
        System.out.println("Enter the coordinates of the Battleship (4 cells): ");
        player1_ship2.placeShip(boardP1.board, 4);
        boardP1.displayBoard();
        System.out.println("Enter the coordinates of the Submarine (3 cells): ");
        player1_ship3.placeShip(boardP1.board, 3);
        boardP1.displayBoard();
        System.out.println("Enter the coordinates of the Cruiser (3 cells): ");
        player1_ship4.placeShip(boardP1.board, 3);
        boardP1.displayBoard();
        System.out.println("Enter the coordinates of the Destroyer (2 cells): ");
        player1_ship5.placeShip(boardP1.board, 2);
        boardP1.displayBoard();
        promptEnterKey();
        System.out.println("Player 2, place your ships to the game field");
        boardP2.displayBoard();
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells): ");
        player2_ship1.placeShip(boardP2.board, 5);
        boardP2.displayBoard();
        System.out.println("Enter the coordinates of the Battleship (4 cells): ");
        player2_ship2.placeShip(boardP2.board, 4);
        boardP2.displayBoard();
        System.out.println("Enter the coordinates of the Submarine (3 cells): ");
        player2_ship3.placeShip(boardP2.board, 3);
        boardP2.displayBoard();
        System.out.println("Enter the coordinates of the Cruiser (3 cells): ");
        player2_ship4.placeShip(boardP2.board, 3);
        boardP2.displayBoard();
        System.out.println("Enter the coordinates of the Destroyer (2 cells): ");
        player2_ship5.placeShip(boardP2.board, 2);
        boardP2.displayBoard();


        promptEnterKey();

        boolean p1Turn = true;
        boolean game = true;
        while (game) {
            if (p1Turn) {
                boardP2.displayFogBoard();
                System.out.print("---------------------");
                System.out.println();
                boardP1.displayBoard();
                System.out.println("Player 1, it's your turn: ");
                shootP1.shootMissile(boardP2.board);
                shootP1.checkIfShipPlayer1Sunk(boardP2.board);
                p1Turn = false;
            } else {
                boardP1.displayFogBoard();
                System.out.print("---------------------");
                System.out.println();
                boardP2.displayBoard();
                System.out.println("Player 2, it's your turn: ");
                shootP2.shootMissile(boardP1.board);
                shootP2.checkIfShipPlayer2Sunk(boardP1.board);
                p1Turn = true;
            }
            if(shootP1.allShipsSunk1 || shootP2.allShipsSunk2){
                System.out.println("You sank the last ship. You won. Congratulations!");
                game=false;
            }
            promptEnterKey();

        }

    }
}

