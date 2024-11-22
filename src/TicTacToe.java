import java.util.Scanner;

    public class TicTacToe {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Tic Tac Toe Game!");

            System.out.print("Enter Player 1 name (X): ");
            String player1 = scanner.nextLine();
            System.out.print("Enter Player 2 name (O): ");
            String player2 = scanner.nextLine();

            GameBoard gameBoard = new GameBoard();
            boolean playing = true;
            int player1Wins = 0;
            int player2Wins = 0;

            while (playing) {
                boolean gameActive = true;
                gameBoard.resetBoard();
                String currentPlayer = player1;
                char currentMark = 'X';

                while (gameActive) {
                    gameBoard.printBoard();
                    System.out.println(currentPlayer + ", choose a position (1-9):");
                    int position;

                    while (true) {
                        try {
                            position = Integer.parseInt(scanner.nextLine());
                            if (gameBoard.isValidMove(position)) {
                                break;
                            } else {
                                System.out.println("Invalid move. Try again.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a number between 1 and 9.");
                        }
                    }

                    gameBoard.makeMove(position, currentMark);

                    if (gameBoard.checkWin(currentMark)) {
                        gameBoard.printBoard();
                        System.out.println(currentPlayer + " wins!");
                        if (currentMark == 'X') {
                            player1Wins++;
                        } else {
                            player2Wins++;
                        }
                        gameActive = false;
                    } else if (gameBoard.isDraw()) {
                        gameBoard.printBoard();
                        System.out.println("It's a draw!");
                        gameActive = false;
                    } else {
                        currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
                        currentMark = currentMark == 'X' ? 'O' : 'X';
                    }
                }

                System.out.println("Scores: " + player1 + " (" + player1Wins + ") - " + player2 + " (" + player2Wins + ")");
                System.out.println("Play again? (yes/no)");
                String response = scanner.nextLine().toLowerCase();
                if (!response.equals("yes")) {
                    playing = false;
                    System.out.println("Thanks for playing!");
                }
            }

            scanner.close();
        }
    }
