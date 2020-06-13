package com.liu.LeetCode.ThirtyDays202004.exercise;

import java.util.ArrayList;
import java.util.List;

public class TD18_MinimumPathSum {
    // Time Out
    public static int minPathSumMy1(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        List<Integer> cache = new ArrayList<>();
        checkPath(grid, m, n, 0, 0, cache, 0);
        int min = Integer.MAX_VALUE;
        for (int i : cache) {
            min = Math.min(min, i);
        }
        return min;
    }

    private static void checkPath(int[][] grid, int m, int n, int i, int j, List<Integer> cache, int path) {
        if (i < m && j < n) {
            checkPath(grid, m, n, i + 1, j, cache, path + grid[i][j]);
            checkPath(grid, m, n, i, j + 1, cache, path + grid[i][j]);
        }
        if (i == m - 1 && j == n - 1) {
            cache.add(path + grid[i][j]);
        }
    }

    public static int minPathSumMy2(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] cache = new int[m][n];
        cache[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            cache[i][0] = cache[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            cache[0][i] = cache[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cache[i][j] = Math.min(cache[i - 1][j], cache[i][j - 1]) + grid[i][j];
            }
        }
        return cache[m - 1][n - 1];
    }
}
