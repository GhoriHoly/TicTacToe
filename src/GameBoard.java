class GameBoard {
    private char[] board;

    public GameBoard() {
        board = new char[9];
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
    }

    public void printBoard() {
        System.out.println(" ");
        for (int i = 0; i < 9; i++) {
            System.out.print(" " + board[i] + " ");
            if (i % 3 < 2) {
                System.out.print("|");
            } else if (i < 8) {
                System.out.println("\n---+---+---");
            }
        }
        System.out.println(" \n");
    }

    public boolean isValidMove(int position) {
        return position >= 1 && position <= 9 && board[position - 1] == ' ';
    }

    public void makeMove(int position, char mark) {
        board[position - 1] = mark;
    }

    public boolean checkWin(char mark) {
        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] condition : winConditions) {
            if (board[condition[0]] == mark && board[condition[1]] == mark && board[condition[2]] == mark) {
                return true;
            }
        }

        return false;
    }

    public boolean isDraw() {
        for (char cell : board) {
            if (cell == ' ') {
                return false;
            }
        }
        return true;
    }
}
