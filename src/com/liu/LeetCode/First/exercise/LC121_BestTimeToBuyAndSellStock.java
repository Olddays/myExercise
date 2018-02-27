package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC121_BestTimeToBuyAndSellStock {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     * <p>
     * Example 1:
     * <p>
     * Input: [7, 1, 5, 3, 6, 4]
     * Output: 5
     * <p>
     * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
     * <p>
     * Example 2:
     * <p>
     * Input: [7, 6, 4, 3, 1]
     * Output: 0
     * <p>
     * In this case, no transaction is done, i.e. max profit = 0.
     */

    public static int getBestTimeToBuyAndSellStockMy1(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length];
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            min = Math.min(prices[i], min);
            dp[i] = Math.max(prices[i] - min, dp[i - 1]);
        }
        return dp[length - 1];
    }
}
