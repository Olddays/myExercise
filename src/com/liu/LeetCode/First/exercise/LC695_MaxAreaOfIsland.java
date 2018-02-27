package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC695_MaxAreaOfIsland {
    /**
     * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
     * <p>
     * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
     * <p>
     * Example 1:
     * <p>
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,1,1,0,1,0,0,0,0,0,0,0,0],
     * [0,1,0,0,1,1,0,0,1,0,1,0,0],
     * [0,1,0,0,1,1,0,0,1,1,1,0,0],
     * [0,0,0,0,0,0,0,0,0,0,1,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * <p>
     * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
     * <p>
     * Example 2:
     * <p>
     * [[0,0,0,0,0,0,0,0]]
     * <p>
     * Given the above grid, return 0.
     * <p>
     * Note: The length of each dimension in the given grid does not exceed 50.
     */

    public static int getMaxAreaOfIslandMy1(int[][] grid) {
        int row = grid.length;
        int result = 0;
        if (row == 0) {
            return result;
        }
        int list = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < list; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int area = 1;
                    area += getIslandArea(i, j, row, list, grid);
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }

    // 写法太傻了=.=MDZZ
    private static int getIslandArea(int i, int j, int row, int list, int[][] grid) {
        int result = 0;
        if (i == 0 && i < row - 1) {
            if (grid[i + 1][j] == 1) { // 右 虽然不可能-.-
                grid[i + 1][j] = 0;
                result++;
                result += getIslandArea(i + 1, j, row, list, grid);
            }
        } else if (i == row - 1 && i > 0) {
            if (grid[i - 1][j] == 1) { // 左
                grid[i - 1][j] = 0;
                result++;
                result += getIslandArea(i - 1, j, row, list, grid);
            }
        } else if (i > 0 && i < row - 1) {
            if (grid[i + 1][j] == 1) { // 右 虽然不可能-.-
                grid[i + 1][j] = 0;
                result++;
                result += getIslandArea(i + 1, j, row, list, grid);
            }
            if (grid[i - 1][j] == 1) { // 左
                grid[i - 1][j] = 0;
                result++;
                result += getIslandArea(i - 1, j, row, list, grid);
            }
        }
        if (j == 0 && j < list - 1) {
            if (grid[i][j + 1] == 1) { // 下
                grid[i][j + 1] = 0;
                result++;
                result += getIslandArea(i, j + 1, row, list, grid);
            }
        } else if (j == list - 1 && j > 0) {
            if (grid[i][j - 1] == 1) { // 上 虽然不可能 -.-
                grid[i][j - 1] = 0;
                result++;
                result += getIslandArea(i, j - 1, row, list, grid);
            }
        } else if (j > 0 && j < list - 1) {
            if (grid[i][j + 1] == 1) { // 下
                grid[i][j + 1] = 0;
                result++;
                result += getIslandArea(i, j + 1, row, list, grid);
            }
            if (grid[i][j - 1] == 1) { // 上 虽然不可能 -.-
                grid[i][j - 1] = 0;
                result++;
                result += getIslandArea(i, j - 1, row, list, grid);
            }
        }
        return result;
    }

    // The idea is to count the area of each island using dfs. During the dfs,
    // we set the value of each point in the island to 0. The time complexity is O(mn).
    public static int getMaxAreaOfIslandAnswer1(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, getAreaOfIsland(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public static int getAreaOfIsland(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return getAreaOfIsland(grid, i + 1, j)
                    + getAreaOfIsland(grid, i - 1, j)
                    + getAreaOfIsland(grid, i, j - 1)
                    + getAreaOfIsland(grid, i, j + 1)
                    + 1;
        }
        return 0;
    }
}
