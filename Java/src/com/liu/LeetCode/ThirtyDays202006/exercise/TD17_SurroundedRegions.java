package com.liu.LeetCode.ThirtyDays202006.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2020/6/17.
 */
public class TD17_SurroundedRegions {
    public static void solveMy1(char[][] board) {
        int m = board.length;
        if (m <= 1) {
            return;
        }
        int n = board[0].length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j] == 'O') {
                    List<String> list = new ArrayList<>();
                    boolean noEdge = checkRange(board, 'O', m, n, i, j, list);
                    if (noEdge) {
                        for (String point : list) {
                            board[Integer.valueOf(point.substring(0, 1))][Integer.valueOf(point.substring(1, 2))] = 'X';
                        }
                    }
                }
            }
        }
    }

    private static boolean checkRange(char[][] board, char target, int m, int n, int i, int j, List<String> list) {
        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
            return false;
        } else {
            String point = i + "" + j;
            boolean noEdge = true;
            if (board[i][j] == target) {
                list.add(point);
            }
            if (board[i - 1][j] == target && !list.contains((i - 1) + "" + j)) {
                noEdge = checkRange(board, target, m, n, i - 1, j, list);
            }
            if (board[i + 1][j] == target && !list.contains((i + 1) + "" + j) && noEdge) {
                noEdge = checkRange(board, target, m, n, i + 1, j, list);
            }
            if (board[i][j - 1] == target && !list.contains(i + "" + (j - 1)) && noEdge) {
                noEdge = checkRange(board, target, m, n, i, j - 1, list);
            }
            if (board[i][j + 1] == target && !list.contains(i + "" + (j + 1)) && noEdge) {
                noEdge = checkRange(board, target, m, n, i, j + 1, list);
            }
            return noEdge;
        }
    }

    public static void solveAnswer1(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        if (board.length < 2 || board[0].length < 2) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        // Any 'O' connected to a boundary can't be turned to 'X', so ...
        // Start from first and last column, turn 'O' to '*'.
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                boundaryDFS(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                boundaryDFS(board, i, n - 1);
            }
        }
        // Start from first and last row, turn '0' to '*'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                boundaryDFS(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                boundaryDFS(board, m - 1, j);
            }
        }
        // post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    // Use DFS algo to turn internal however boundary-connected 'O' to '*';
    private static void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '*';
        }
        if (i > 1 && board[i - 1][j] == 'O') {
            boundaryDFS(board, i - 1, j);
        }
        if (i < board.length - 2 && board[i + 1][j] == 'O') {
            boundaryDFS(board, i + 1, j);
        }
        if (j > 1 && board[i][j - 1] == 'O') {
            boundaryDFS(board, i, j - 1);
        }
        if (j < board[i].length - 2 && board[i][j + 1] == 'O') {
            boundaryDFS(board, i, j + 1);
        }
    }
}
