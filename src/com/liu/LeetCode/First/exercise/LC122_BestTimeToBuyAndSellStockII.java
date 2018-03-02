package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC122_BestTimeToBuyAndSellStockII {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     */

    public static int getBestTimeToBuyAndSellStockIIMy1(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < length; i++) {
            if (prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }
}
