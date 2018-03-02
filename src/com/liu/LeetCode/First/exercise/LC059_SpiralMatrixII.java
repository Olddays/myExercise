package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC059_SpiralMatrixII {
    /**
     * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
     * <p>
     * For example,
     * Given n = 3,
     * You should return the following matrix:
     * <p>
     * [
     * [ 1, 2, 3 ],
     * [ 8, 9, 4 ],
     * [ 7, 6, 5 ]
     * ]
     */

    public static int[][] getSpiralMatrixIIMy1(int n) {
        int[][] result = new int[n][n];
        // 从外到里第i圈的数字个数是(n-i)*4
        int nowNum = 1;
        for (int cycle = 0; cycle < (n + 1) / 2; cycle++) {
            // 一圈一圈写
            for (int i = cycle; i < n - cycle; i++) {
                // 第cycle行
                result[cycle][i] = nowNum++;
            }
            for (int i = cycle + 1; i < n - cycle; i++) {
                // 第n-1-cycle列
                result[i][n - 1 - cycle] = nowNum++;
            }
            for (int i = n - 2 - cycle; i >= cycle; i--) {
                // 第n-1-cycle行
                result[n - 1 - cycle][i] = nowNum++;
            }
            for (int i = n - 2 - cycle; i > cycle; i--) {
                // 第cycle列
                result[i][cycle] = nowNum++;
            }
        }
        return result;
    }
}
