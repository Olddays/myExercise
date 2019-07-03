package com.liu.LeetCode.First.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liu on 2017/9/30.
 */
public class LC036_ValidSudoku {
    /**
     * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
     * <p>
     * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
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
     * A partially filled sudoku which is valid.
     * <p>
     * Note:
     * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
     */

    public static boolean getValidSudokuAnswer1(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columns.add(board[j][i])) {
                    return false;
                }
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Collect the set of things we see, encoded as strings. For example:
     * <p>
     * '4' in row 7 is encoded as "(4)7".
     * '4' in column 7 is encoded as "7(4)".
     * '4' in the top-right block is encoded as "0(4)2".
     * <p>
     * Scream false if we ever fail to add something because it was already added (i.e., seen before).
     */
    public static boolean getValidSudokuAnswe2(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i / 3 + b + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Just occurred to me that we can also make it really clear and self-explaining. I'm loving it.
    public static boolean getValidSudokuAnswer3(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Each time send the coordinates to check if the board is partially valid.
    public static boolean getValidSudokuAnswe4(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isParticallyValid(board, i, 0, i, 8)) {
                return false;
            }
            if (!isParticallyValid(board, 0, i, 8, i)) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isParticallyValid(board, i * 3, j * 3, i * 3 + 2, j * 3 + 2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isParticallyValid(char[][] board, int x1, int y1, int x2, int y2) {
        Set singleSet = new HashSet();
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (board[i][j] != '.') if (!singleSet.add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
