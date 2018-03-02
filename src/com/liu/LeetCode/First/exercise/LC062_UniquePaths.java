package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC062_UniquePaths {
    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * <p>
     * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * <p>
     * How many possible unique paths are there?
     * <p>
     * Note: m and n will be at most 100.
     */

    // 通过绘图可知,是一个搜索问题
    // 可以考虑每个拐点的作为一个树分支的节点,但是是一种特殊的树
    // 对于3*3的矩阵有:
    // a - 0 - 0
    // |   |   |
    // 0 - 0 - 0
    // |   |   |
    // 0 - 0 - b
    // 目的是寻找从a到b的不重复路径个数
    // 暂时可以认为是一个动态规划问题,子问题是在(m-i)*(n-j)的矩阵中的路径个数
    public static int getUniquePathsMy1(int m, int n) {
        // 我们认为这个是一个最优化问题,通过dp方案来求解
        int[][] dpCache = new int[m][n];
        for (int i = 0; i < m; i++) {
            // 将第一列置为1 表示向下的初始m*1矩阵情况
            dpCache[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            // 将第一行置为1 表示向右的初始1*n矩阵情况
            dpCache[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 即每个点的到达方案个数 等于 他上方的点的到达方案个数 加 他左边点的到达方案个数
                dpCache[i][j] = dpCache[i - 1][j] + dpCache[i][j - 1];
            }
        }
        return dpCache[m - 1][n - 1];
    }
}
