package com.liu.LeetApp.exercise;

/**
 * Created by liu on 2016/12/7.
 */
public class LA012_BinarySearchTreeIterator {

    // Say you have an array for which the ith element is the price of a given stock on day i.

    // Design an algorithm to find the maximum profit. You may complete at most k transactions.

    // Note:
    // You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

    // Difficulty: Hard

    // Error 写错了..认真写代码
    public static int bestTimeToBuyAndSellStockIVMy1(int[] input) {
        if (null == input || input.length <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i] - 1) {
                result += input[i] - input[i - 1];
            }
        }
        return result;
    }

    // Error 题意理解错了 少了一个参数输入
    public static int bestTimeToBuyAndSellStockIVMy2(int[] input) {
        if (null == input || input.length <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i - 1]) {
                result += input[i] - input[i - 1];
            }
        }
        return result;
    }


    public static int bestTimeToBuyAndSellStockIVAnswer(int[] input, int time) {
        if (time == 0 || null == input || input.length <= 1) {
            return 0;
        }
        int result = 0;
        if (time >= input.length / 2) {
            for (int i = 1; i < input.length; i++) {
                if (input[i] > input[i - 1]) {
                    result += input[i] - input[i - 1];
                }
            }
            return result;
        }
        int n = input.length;
        int[][] mustSell = new int[n + 1][n + 1]; // mustSell[i][j] 表示前i天,至多进行j次交易,第i天必须sell时的最大收益
        int[][] globalBest = new int[n + 1][n + 1]; // globalBest[i][j] 表示前i天,至多进行j次交易,第i天可以不sell的最大收益
        mustSell[0][0] = globalBest[0][0] = 0;
        for (int i = 1; i <= time; i++) {
            mustSell[0][i] = globalBest[0][i] = 0;
        }
        for (int i = 1; i < n; i++) {
            int gainOrLose = input[i] - input[i - 1];
            mustSell[i][0] = 0;
            for (int j = 1; j <= time; j++) {
                mustSell[i][j] = Math.max(globalBest[i - 1][j - 1] + gainOrLose, mustSell[i - 1][j] + gainOrLose);
                globalBest[i][j] = Math.max(globalBest[i - 1][j], mustSell[i][j]);
            }
        }
        return globalBest[n - 1][time];
    }

}
