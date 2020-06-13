package com.liu.LeetCode.First.exercise;

public class LC200_NumberOfIslands {

    public static int numIslands(char[][] grid) {
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
                if (grid[i][j] == '1') {
                    // 找到一个时，将与之相连的所有点都给刷掉，并将结果计数+1
                    deepFirstSearch(grid, i, j, m, n);
                    result++;
                }
            }
        }
        return result;
    }

    private static void deepFirstSearch(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        deepFirstSearch(grid, i + 1, j, m, n); // 上
        deepFirstSearch(grid, i - 1, j, m, n); // 下
        deepFirstSearch(grid, i, j + 1, m, n); // 左
        deepFirstSearch(grid, i, j - 1, m, n); // 右
    }
}
