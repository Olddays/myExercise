package com.liu.LeetCode.FifteenPatterns.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC051_NQueens {

    private static List<List<String>> solveNQueensMy1(int n) {
        List<List<String>> result = new ArrayList<>();
        // Arrays to mark if a column, diagonal, or anti-diagonal is occupied
        int[] columns = new int[n];
        int[] diagonals = new int[n * 2];
        int[] antiDiagonals = new int[n * 2];
        // Chessboard representation
        String[][] board = new String[n][n];
        // Initialize the board with empty strings
        for (int i = 0; i < n; ++i) {
            Arrays.fill(board[i], ".");
        }

        nQueensDeepFirstSearch(result, board, columns, diagonals, antiDiagonals, n, 0);
        return result;
    }

    private static void nQueensDeepFirstSearch(List<List<String>> result, String[][] board, int[] columns,
                                               int[] diagonals, int[] antiDiagonals, int size, int row) {
        // If all queens are placed
        if (row == size) {
            List<String> oneSolution = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                // Join the row to form the string
                oneSolution.add(String.join("", board[i]));
            }
            // Add the current board configuration to the solutions list
            result.add(oneSolution);
            return;
        }
        // Iterate through each column for the current row
        for (int col = 0; col < size; ++col) {
            // Check if the current position is safe for placing a queen
            if (columns[col] + diagonals[row + col] + antiDiagonals[size - row + col] == 0) {
                // Place the queen
                board[row][col] = "Q";
                // Mark current column, diagonal, and anti-diagonal as occupied
                columns[col] = diagonals[row + col] = antiDiagonals[size - row + col] = 1;
                // Continue to place the next queen
                nQueensDeepFirstSearch(result, board, columns, diagonals, antiDiagonals, size, row + 1);
                // Backtrack and remove the queen
                columns[col] = diagonals[row + col] = antiDiagonals[size - row + col] = 0;
                board[row][col] = ".";
            }
        }
    }

    public static void main(String[] args) {
        int[] nSet = new int[]{
                4,
                1,
        };
        List<List<String>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < nSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = solveNQueensMy1(nSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("solveNQueens My1 result" + i + " ");
            for (List<String> nums : result) {
                for (String num : nums) {
                    System.out.print(num + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
