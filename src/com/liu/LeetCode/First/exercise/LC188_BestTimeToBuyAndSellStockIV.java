package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC188_BestTimeToBuyAndSellStockIV {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete at most k transactions.
     * <p>
     * Note:
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * <p>
     * Credits:
     * Special thanks to @Freezen for adding this problem and creating all test cases.
     */
    public static int getBestTimeToBuyAndSellStockIVMy1(int k, int[] prices) {
        int length = prices.length;
        if (k >= length / 2) {
            int result = 0;
            // 当k大于等于整体价格长度的二分之一时,其实等于说可以进行任意次数的交易
            for (int i = 1; i < length; i++)
                if (prices[i] > prices[i - 1]) {
                    result += prices[i] - prices[i - 1];
                }
            return result;
        }

        int[][] dp = new int[k + 1][length];
        for (int i = 1; i <= k; i++) {
            int cache = prices[0];
            for (int j = 1; j < length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - cache);
                cache = Math.min(cache, prices[j] - dp[i - 1][j - 1]);
            }
        }
        return dp[k][length - 1];
    }

    // The general idea is DP, while I had to add a "quickSolve" function to tackle some corner cases to avoid TLE.
    // DP: t(i,j) is the max profit for up to i transactions by time j (0<=i<=K, 0<=j<=T).
    public static int getBestTimeToBuyAndSellStockIVAnswer1(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) {
            return quickSolve(prices);
        }
        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


    private static int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
