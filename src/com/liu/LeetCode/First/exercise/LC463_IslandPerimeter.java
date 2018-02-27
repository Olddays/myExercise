package com.liu.LeetCode.First.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC463_IslandPerimeter {
    /**
     * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
     * <p>
     * Example:
     * <p>
     * [[0,1,0,0],
     * [1,1,1,0],
     * [0,1,0,0],
     * [1,1,0,0]]
     * <p>
     * Answer: 16
     * Explanation: The perimeter is the 16 yellow stripes in the image below:
     */

    // 未考虑输入非正方形的情况
    public static int getIslandPerimeterMy1(int[][] grid) {
        int length = grid.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        int landSum = 0;
        int edgeSum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1) {
                    landSum++;
                    if (i > 0 && grid[i - 1][j] == 1) { // 上
                        edgeSum++;
                    }
                    if (i < length - 1 && grid[i + 1][j] == 1) { // 下
                        edgeSum++;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) { // 左
                        edgeSum++;
                    }
                    if (j < landSum - 1 && grid[i][j + 1] == 1) { // 右
                        edgeSum++;
                    }
                }
            }
        }
        return landSum * 4 - edgeSum;
    }


    public static int getIslandPerimeterMy2(int[][] grid) {
        int row = grid.length;
        int result = 0;
        if (row == 0) {
            return result;
        }
        int list = grid[0].length;
        if (list == 0) {
            return result;
        }
        int landSum = 0;
        int edgeSum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < list; j++) {
                if (grid[i][j] == 1) {
                    landSum++;
                    if (i > 0 && grid[i - 1][j] == 1) { // 上
                        edgeSum++;
                    }
                    if (i < row - 1 && grid[i + 1][j] == 1) { // 下
                        edgeSum++;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) { // 左
                        edgeSum++;
                    }
                    if (j < list - 1 && grid[i][j + 1] == 1) { // 右
                        edgeSum++;
                    }
                }
            }
        }
        return landSum * 4 - edgeSum;
    }
}
