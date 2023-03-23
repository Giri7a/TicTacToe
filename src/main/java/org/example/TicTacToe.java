package org.example;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        int player = 1;
        char mark = 'X';
        boolean gameOn = true;

        while (gameOn) {
            drawBoard(board);

            int row, col;
            Scanner sc = new Scanner(System.in);

            // get row and column from player
            System.out.println("Player " + player + "'s turn. Enter row (1-3):");
            row = sc.nextInt() - 1;
            System.out.println("Enter column (1-3):");
            col = sc.nextInt() - 1;

            // check if chosen cell is valid
            if (board[row][col] != ' ') {
                System.out.println("Invalid move, try again.");
                continue;
            }

            // place the mark on board
            board[row][col] = mark;

            // check if game is won
            if (isWinner(board, mark)) {
                drawBoard(board);
                System.out.println("Player " + player + " wins!");
                gameOn = false;
            } else if (isBoardFull(board)) {
                drawBoard(board);
                System.out.println("Game is a draw.");
                gameOn = false;
            }

            // switch player and mark
            player = player == 1 ? 2 : 1;
            mark = mark == 'X' ? 'O' : 'X';
        }
    }

    public static void drawBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static boolean isWinner(char[][] board, char mark) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) {
                return true;
            }
        }

        // check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == mark && board[1][j] == mark && board[2][j] == mark) {
                return true;
            }
        }

        // check diagonals
        if (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) {
            return true;
        }
        if (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark) {
            return true;
        }

        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
