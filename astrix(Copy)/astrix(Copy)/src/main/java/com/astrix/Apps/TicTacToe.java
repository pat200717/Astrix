package com.astrix.Apps;

import com.astrix.astrixModule.AstrixConsole;

public class TicTacToe extends Apps {

    AstrixConsole con = new AstrixConsole();

    private final char[] board = new char[9];

    public TicTacToe() {
        super(false);
    }

    @Override
    public String getName() {
        return "Tic Tac Toe";
    }

    @Override
    public String getCode() {
        return "tictactoe";
    }

    @Override
    public String creatorName() {
        return "John Rafael Esquillo";
    }

    @Override
    public double sizeFile() {
        return 5.0;
    }

    @Override
    public String version() {
        return "1.0";
    }

    @Override
    public String description() {
        return "A classic two-player Tic-Tac-Toe game.";
    }

    @Override
    public void run() {

        while (true) {

            initializeBoard();

            char currentPlayer = 'X';
            int movesPlayed = 0;
            boolean gameWon = false;

            while (movesPlayed < 9 && !gameWon) {

                con.clear();
                con.title("TIC TAC TOE");

                printBoard();

                int position = readValidMove(currentPlayer);

                if (position == -1) {
                    return;
                }

                board[position] = currentPlayer;
                movesPlayed++;

                gameWon = checkWin(currentPlayer);

                if (!gameWon) {
                    currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
                }
            }

            con.clear();
            con.title("TIC TAC TOE");

            printBoard();

            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins!");
            } else {
                System.out.println("It's a draw!");
            }

            con.lineSpacing(2);

            System.out.println("1. Play Again");
            System.out.println("2. Back to Home Screen");

            int choice = con.choose();

            if (choice == 1) {
                continue;
            }

            if (choice == 2) {
                return;
            }

            System.out.println("Invalid Input");
            con.doublePause();
        }
    }

    private void initializeBoard() {

        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
    }

    private void printBoard() {

        System.out.println("Positions:");
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("-----------");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("-----------");
        System.out.println(" 7 | 8 | 9 ");

        System.out.println();

        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);

        System.out.println();
        System.out.println("10. Back to Home Screen");
        System.out.println();
    }

    private int readValidMove(char currentPlayer) {

        while (true) {

            System.out.print("Player " + currentPlayer + ", choose: ");

            int move = con.choose();

            if (move == 10) {
                return -1;
            }

            if (move < 1 || move > 9) {
                System.out.println("Please enter 1-9 or 10 to go back.");
                con.doublePause();
                continue;
            }

            int index = move - 1;

            if (board[index] != ' ') {
                System.out.println("That spot is already taken.");
                con.doublePause();
                continue;
            }

            return index;
        }
    }

    private boolean checkWin(char player) {

        int[][] winPatterns = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
        };

        for (int[] pattern : winPatterns) {

            if (board[pattern[0]] == player
                    && board[pattern[1]] == player
                    && board[pattern[2]] == player) {

                return true;
            }
        }

        return false;
    }
}