package com.liu.LeetCode.ThirtyDays202007.exercise;

/**
 * Created by Liu on 2020/7/7.
 */
public class TD07_IslandPerimeter {

    public enum Direction {
        up,
        down,
        left,
        right
    }

    public static int islandPerimeter(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        result--;
                    }
                    if (i < m - 1 && grid[i + 1][j] == 1) {
                        result--;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        result--;
                    }
                    if (j < n - 1 && grid[i][j + 1] == 1) {
                        result--;
                    }
                }
            }
        }
        return result;
    }
}
