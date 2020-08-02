package com.liu.LeetCode.ThirtyDays202007.exercise;

/**
 * Created by Liu on 2020/7/21.
 */
public class TD21_WordSearch {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) {
            return false;
        }
        int n = board[0].length;
        if (n == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, chars, 0, i, j, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean searchWord(char[][] board, char[] chars, int x, int i, int j, int m, int n) {
        if (x == chars.length) {
            return true;
        }
        if (i < 0 || j < 0 || i == m || j == n) {
            return false;
        }
        char c = chars[x];
        if (board[i][j] != c) {
            return false;
        }
        char cache = board[i][j];
        board[i][j] = ' ';
        boolean hasResult = searchWord(board, chars, x + 1, i - 1, j, m, n)
                || searchWord(board, chars, x + 1, i + 1, j, m, n)
                || searchWord(board, chars, x + 1, i, j - 1, m, n)
                || searchWord(board, chars, x + 1, i, j + 1, m, n);
        board[i][j] = cache;
        return hasResult;
    }
}
