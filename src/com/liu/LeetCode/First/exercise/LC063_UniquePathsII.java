package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC063_UniquePathsII {
    /**
     * Follow up for "Unique Paths":
     * <p>
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * <p>
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * <p>
     * For example,
     * <p>
     * There is one obstacle in the middle of a 3x3 grid as illustrated below.
     * <p>
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     * <p>
     * The total number of unique paths is 2.
     * <p>
     * Note: m and n will be at most 100.
     */

    // 通过绘图可知,是一个搜索问题
    // 可以考虑每个拐点的作为一个树分支的节点,但是是一种特殊的树
    // 对于3*3的矩阵有:
    // a - 0 - 0
    // |   |   |
    // 0 - 1 - 0
    // |   |   |
    // 0 - 0 - b
    // 目的是寻找从a到b的不重复路径个数,且其中标为1的数字表示不可以通过的位置
    // 暂时可以认为是一个动态规划问题,子问题是在(m-i)*(n-j)的矩阵中的路径个数
    // 要注意考虑一下阻碍在第一行或第一列的情况

    // 没有考虑起点就是障碍的情况..
    public static int getUniquePathsIIMy1(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row == 0) {
            return 1;
        }
        int list = obstacleGrid[0].length;
        int[][] dpCache = new int[row][list];
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 0) {
                dpCache[i][0] = 1;
            }
        }
        for (int i = 0; i < list; i++) {
            if (obstacleGrid[0][i] == 0) {
                dpCache[0][i] = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < list; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dpCache[i][j] = dpCache[i - 1][j] + dpCache[i][j - 1];
                }
            }
        }
        return dpCache[row - 1][list - 1];
    }

    public static int getUniquePathsIIMy2(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row == 0) {
            // 数组为空,主要是避免crash随便给了个返回值
            return 1;
        }
        if (obstacleGrid[0][0] == 1) {
            // 起点被堵住了..
            return 0;
        }
        int list = obstacleGrid[0].length;
        int[][] dpCache = new int[row][list];
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 0) {
                dpCache[i][0] = 1;
            } else {
                // 被挡住了 此时由于只能向下和向右移动,所以break
                break;
            }
        }
        for (int i = 0; i < list; i++) {
            if (obstacleGrid[0][i] == 0) {
                dpCache[0][i] = 1;
            } else {
                // 被挡住了 此时由于只能向下和向右移动,所以break
                break;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < list; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dpCache[i][j] = dpCache[i - 1][j] + dpCache[i][j - 1];
                }
            }
        }
        return dpCache[row - 1][list - 1];
    }
}
