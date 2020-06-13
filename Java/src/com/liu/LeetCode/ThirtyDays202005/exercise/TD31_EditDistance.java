package com.liu.LeetCode.ThirtyDays202005.exercise;

/**
 * Created by Liu on 2020/6/1.
 */
public class TD31_EditDistance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            cost[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            cost[0][i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    cost[i + 1][j + 1] = cost[i][j];
                } else {
                    cost[i + 1][j + 1] = Math.min(cost[i][j], Math.min(cost[i][j + 1], cost[i + 1][j]));
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];
    }
}
