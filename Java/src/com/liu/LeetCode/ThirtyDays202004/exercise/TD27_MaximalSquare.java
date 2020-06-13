package com.liu.LeetCode.ThirtyDays202004.exercise;

/**
 * Created by Liu on 2020/4/27.
 */
public class TD27_MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int max = 0;
        if (matrix[0][0] == '1') {
            max = 1;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - i; j++) {
                int z = i + j;
                char c = matrix[i][z];
                int gap = dp[i][z];
                if (c == '1') {
                    for (int x = 1; x <= gap; x++) {
                        char left = matrix[i - x][z];
                        char up = matrix[i][z - x];
                        if (left == '1' && up == '1') {
                            dp[i + 1][z + 1] = x + 1;
                        } else {
                            dp[i + 1][z + 1] = x;
                            break;
                        }
                    }
                    max = Math.max(dp[i + 1][z + 1], max);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m - j; i++) {
                int z = i + j;
                char c = matrix[z][j];
                int gap = dp[z][j];
                if (c == '1') {
                    for (int x = 1; x <= gap; x++) {
                        char left = matrix[z - x][j];
                        char up = matrix[z][j - x];
                        if (left == '1' && up == '1') {
                            dp[z + 1][j + 1] = x + 1;
                        } else {
                            dp[z + 1][j + 1] = x;
                            break;
                        }
                    }
                    max = Math.max(dp[z + 1][j + 1], max);
                }
            }
        }
        return max * max;
    }
}
