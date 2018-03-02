package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC037_SudokuSolver {
    /**
     * Empty cells are indicated by the character '.'.
     * <p>
     * You may assume that there will be only one unique solution.
     * <p>
     * 5 3 x  x 7 x  x x x
     * 6 x x  1 9 5  x x x
     * x 9 8  x x x  x 6 x
     * <p>
     * 8 x x  x 6 x  x x 3
     * 4 x x  8 x 3  x x 1
     * 7 x x  x 2 x  x x 6
     * <p>
     * x 6 x  x x x  2 8 x
     * x x x  4 1 9  x x 5
     * x x x  x 8 x  x 7 9
     * <p>
     * A sudoku puzzle...
     * <p>
     * 5 3 4  6 7 8  9 1 2
     * 6 7 2  1 9 5  3 4 8
     * 1 9 8  3 4 2  5 6 7
     * <p>
     * 8 5 9  7 6 1  4 2 3
     * 4 2 6  8 5 3  7 9 1
     * 7 1 3  9 2 4  8 5 6
     * <p>
     * 9 6 1  5 3 7  2 8 4
     * 2 8 7  4 1 9  6 3 5
     * 3 4 5  2 8 6  1 7 9
     * <p>
     * ...and its solution numbers marked in red.
     */

    // Try 1 through 9 for each cell. The time complexity should be 9 ^ m (m represents the number of blanks to be filled in),
    // since each blank can have 9 choices. Details see comments inside code.
    public static void getSudokuSolverAnswer1(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    public static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {//trial. Try 1 through 9
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; //Put c for this cell
                            if (solve(board)) {
                                return true; //If it's the solution return true
                            } else {
                                board[i][j] = '.'; //Otherwise go back
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false; //check row
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false; //check column
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false; //check 3*3 block
            }
        }
        return true;
    }
}
