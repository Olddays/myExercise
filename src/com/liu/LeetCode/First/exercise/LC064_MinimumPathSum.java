package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC064_MinimumPathSum {
    /**
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     * <p>
     * Note: You can only move either down or right at any point in time.
     */

    // 这个就更加动归了..寻找最小路径,每个点上的值表示了此点的距离
    public static int getMinimumPathSumMy1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dpCache = new int[m][n];
        dpCache[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dpCache[i][0] += grid[i][0] + dpCache[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            dpCache[0][i] += grid[0][i] + dpCache[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dpCache[i][j] = Math.min(dpCache[i - 1][j] + grid[i][j],
                        dpCache[i][j - 1] + grid[i][j]);
            }
        }
        return dpCache[m - 1][n - 1];
    }
}
