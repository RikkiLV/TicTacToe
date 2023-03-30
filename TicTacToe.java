import java.util.Scanner;
public class TicTacToe {

    //Global string array for the board
    static String[] board = new String[10];

    // Function: main()
    // Description: Driver of the game.

    public static void main(String[] args) {

       //Initialize how to get user input through Scanner
       Scanner input = new Scanner(System.in);
       String choice;

       do {
       //The title
       System.out.println("|---------------------------------|");
       System.out.println("|\t\t\t   F S U\t\t\t  |");
       System.out.println("| Welcome to my Tic Tac Toe game! |");
       System.out.println("|---------------------------------|");

       //Displays the board
       int i = 0;
       while (i <= 9) {
           board[i] = String.valueOf(i + 1);
           i = i + 1;
       }
       theboard();

       //Empties the board
       emptyboard();

       //The Play
       turns();

       //Play Again using a do-while
       System.out.print("Do you want to play again? (Yes/No): ");
       choice = input.nextLine();
      } while (choice != "No" || choice != "no");


    }

    // Function: theboard()
    // Description: Creates the board of the game using the array

    public static void theboard() {
        System.out.println("\t\t\t|---|---|---|");
        System.out.println("\t\t\t| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("\t\t\t|---|---|---|");
        System.out.println("\t\t\t| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("\t\t\t|---|---|---|");
        System.out.println("\t\t\t| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("\t\t\t|---|---|---|");
    }

    // Function: turns()
    // Description: The game play aspect of the game. Turn-based in where player one is 'X' and goes first.
    // Player two is 'O' and goes second. There's an index, turn = 1, where it decides that player one goes first.
    // After that round is finished, turn + 1 = 2, and player two will only go if turn = 2. After player two goes,
    // then turn - 1 = 1, which initiates player one to go again.
    //
    // It consists of a do-while loop which means that it will keep looping until one player wins first. In each turn,
    // there is a do-while for input validation before the player's move is put on the board. After each player makes
    // a move, then the board will be displayed.

    public static void turns() {

        String playerOne = "X", playerTwo = "O";
        Scanner input = new Scanner(System.in);

        int turn = 1;
        int playerOneMove, playerTwoMove;


        //Do-loop will play while either player has not won yet
        do {
            if (turn == 1) {

                //Input validation usng do-while loop for PLAYER ONE
                do {
                    System.out.println("\tPlayer one is 'X'! ");
                    System.out.println("\tFrom 1-9, enter your move:");
                    playerOneMove = Integer.parseInt(input.nextLine());
                }
                while(!validMove(playerOneMove));

                //Uses function playerOne(move) in order to put their move on the board
                playerOne(playerOneMove);
                //Ends the player's turn
                turn = turn + 1;
                //Displays the board
                theboard();
            } else if (turn == 2) {

                //Input validation usng do-while loop for PLAYER TWO
                do {
                    System.out.println("\tPlayer two is 'O'! ");
                    System.out.println("\tFrom 1-9, enter your move:");
                    playerTwoMove = Integer.parseInt(input.nextLine());
                }
                while(!validMove(playerTwoMove));

                //Uses function playerOne(move) in order to put their move on the board
                playerTwo(playerTwoMove);
                //Ends the player's turn
                turn = turn - 1;
                //Displays the board
                theboard();
            }
        } while((!winMoves(playerOne)) && (!winMoves(playerTwo)));

        //If-statement will display which player won
        if (winMoves(playerOne)) {
            System.out.println("Player One Win!");
        } else if (winMoves(playerTwo)) {
            System.out.println("Player Two Win!");
        }
    }

    // Function: playerOne()
    // Description: This takes in player one's move and uses an if-statement in order to match the move 1-9
    // to the board arr 0-8. Since player one is 'X', it will stamp that on the board.

    public static void playerOne(int move) {

        if (move == 1) {
            board[0] = "X";
        }
        else if (move == 2) {
            board[1] = "X";
        }
        else if (move == 3) {
            board[2] = "X";
        }
        else if (move == 4) {
            board[3] = "X";
        }
        else if (move == 5) {
            board[4] = "X";
        }
        else if (move == 6) {
            board[5] = "X";
        }
        else if (move == 7) {
            board[6] = "X";
        }
        else if (move == 8) {
            board[7] = "X";
        }
        else if (move == 9) {
            board[8] = "X";
        }
    }

    // Function: playerTwo()
    // Description: This takes in player two's move and uses an if-statement in order to match the move 1-9
    // to the board arr 0-8. Since player two is 'O', it will stamp that on the board.
    public static void playerTwo(int move) {

        if (move == 1) {
            board[0] = "O";
        }
        else if (move == 2) {
            board[1] = "O";
        }
        else if (move == 3) {
            board[2] = "O";
        }
        else if (move == 4) {
            board[3] = "O";
        }
        else if (move == 5) {
            board[4] = "O";
        }
        else if (move == 6) {
            board[5] = "O";
        }
        else if (move == 7) {
            board[6] = "O";
        }
        else if (move == 8) {
            board[7] = "O";
        }
        else if (move == 9) {
            board[8] = "O";
        }
    }

    // Function: emptyboard()
    // Description: Will empty the board from 1-9 instruction using a for-loop.
    public static void emptyboard() {

        int i = 0;

        //Board[index] will be assigned a space to make it seem empty.
        while (i <= 9) {
            board[i] = " ";
            i = i + 1;
        }

    }

    // Function: validMove()
    // Description: This will check whether a player's move is valid. It returns true if the move is empty
    // and will display "Invalid move." and return false otherwise.
    public static boolean validMove(int move){

        if(board[move-1] == " ") {
            return true;
        }
        else System.out.println("\tInvalid Move.");
        return false;
    }

    // Function: winMoves()
    // Description: This takes in a player and determines whether they are player one or two. If it is player one,
    // then it will check if the board has any of player one's winning moves. If it does, then it returns true and if
    // it doesn't then it returns false. The same goes for player two.
    public static boolean winMoves(String player) {

        String playerOne = "X", playerTwo = "O";

        //The winning moves is the combination of the moves in certain alignments. Such as straight across,
        //downward, and diagonally. This has the combinations of all of these in a 3x3 board.

        if (player.equals(playerOne)) {
            if ((board[0].equals(playerOne) && board[1].equals(playerOne) && board[2].equals(playerOne)) ||
                    (board[3].equals(playerOne) && board[4].equals(playerOne) && board[5].equals(playerOne)) ||
                    (board[6].equals(playerOne) && board[7].equals(playerOne) && board[8].equals(playerOne)) ||
                    (board[1].equals(playerOne) && board[5].equals(playerOne) && board[6].equals(playerOne)) ||
                    (board[3].equals(playerOne) && board[5].equals(playerOne) && board[7].equals(playerOne)) ||
                    (board[1].equals(playerOne) && board[4].equals(playerOne) && board[7].equals(playerOne)) ||
                    (board[2].equals(playerOne) && board[5].equals(playerOne) && board[8].equals(playerOne)) ||
                    (board[3].equals(playerOne) && board[6].equals(playerOne) && board[9].equals(playerOne))) {
                return true;
            }
        }
        else if (player.equals(playerTwo)) {
            if ((board[0].equals(playerTwo) && board[1].equals(playerTwo) && board[2].equals(playerTwo)) ||
                    (board[3].equals(playerTwo) && board[4].equals(playerTwo) && board[5].equals(playerTwo)) ||
                    (board[6].equals(playerTwo) && board[7].equals(playerTwo) && board[8].equals(playerTwo)) ||
                    (board[1].equals(playerTwo) && board[5].equals(playerTwo) && board[6].equals(playerTwo)) ||
                    (board[3].equals(playerTwo) && board[5].equals(playerTwo) && board[7].equals(playerTwo)) ||
                    (board[1].equals(playerTwo) && board[4].equals(playerTwo) && board[7].equals(playerTwo)) ||
                    (board[2].equals(playerTwo) && board[5].equals(playerTwo) && board[8].equals(playerTwo)) ||
                    (board[3].equals(playerTwo) && board[6].equals(playerTwo) && board[9].equals(playerTwo))) {
                return true;
            }
        }

        return false;
    }
}