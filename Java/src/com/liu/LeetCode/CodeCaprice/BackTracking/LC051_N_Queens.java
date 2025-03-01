package com.liu.LeetCode.CodeCaprice.BackTracking;

import java.util.*;

public class LC051_N_Queens {
    private static List<List<String>> solveNQueensMy1(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] columns = new int[n];
        int[] diagonals = new int[n * 2];
        int[] antiDiagonal = new int[n * 2];
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], ".");
        }
        backtrackMy1(result, board, columns, diagonals, antiDiagonal, 0, n);
        return result;
    }

    // row控制遍历的是第几行
    private static void backtrackMy1(List<List<String>> result, String[][] board, int[] columns, int[] diagonals, int[] antiDiagonal, int row, int n) {
        if (row == n) {
            List<String> cache = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                cache.add(String.join("", board[i]));
            }
            result.add(cache);
        }
        for (int col = 0; col < n; col++) {
            if (columns[col] == 1 || diagonals[row + col] == 1 || antiDiagonal[n - row + col] == 1) { // 避免横、竖、斜对角线有重复
                continue;
            }
            columns[col] = 1;
            diagonals[row + col] = 1;
            antiDiagonal[n - row + col] = 1;
            board[row][col] = "Q";
            backtrackMy1(result, board, columns, diagonals, antiDiagonal, row + 1, n);
            columns[col] = 0;
            diagonals[row + col] = 0;
            antiDiagonal[n - row + col] = 0;
            board[row][col] = ".";
        }
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                4,
                1,
        };
        List<List<String>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = solveNQueensMy1(nList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("solveNQueens My1 result" + i + " ");
            for (List<String> list : result) {
                for (String val : list) {
                    System.out.print(val + ", ");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
