package com.liu.LeetCode.CodeCaprice.DP;

public class LC188_BestTimeToBuyAndSellStockIV {

    // Beats 80.02%
    private static int maxProfitMy1(int k, int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        // dp[i][j] 表示在i天股票状态为j时的最大利润
        int[][] dp = new int[length][2 * k + 1];
        dp[0][0] = 0;
        for (int i = 1; i < 2 * k + 1; i += 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {
                if (j % 2 == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
            }
        }
        return dp[length - 1][2 * k];
    }

    // Beats 100.00%
    // 转化为了一个背包问题
    private static int maxProfitAnswer1(int k, int[] prices) {
        int n = prices.length;
        int[] profits = new int[n]; // Array to store maximum profit at each index

        // Iterate for each transaction count from 1 to k
        for (int i = 1; i <= k; i++) {
            // Keeps track of the maximum possible (sell price + previous profit)
            int max = Integer.MIN_VALUE;
            int profit = 0; // Tracks the maximum profit for this transaction

            // Traverse prices in reverse order to build up the profits array
            for (int j = n - 1; j >= 0; j--) {
                // Update `max` to store the best price to sell at, considering previous profits
                max = Math.max(max, prices[j] + profits[j]);

                // Compute the best profit if we were to buy at prices[j] and sell at `max`
                profit = Math.max(profit, max - prices[j]);

                // Store the best profit found so far for this transaction count
                profits[j] = profit;
            }
        }
        return profits[0]; // Maximum profit attainable with `k` transactions
    }

    public static void main(String[] args) {
        int[] kSet = new int[]{
                2,
                2,
        };
        int[][] pricesSet = new int[][]{
                {2, 4, 1},
                {3, 2, 6, 5, 0, 3},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < pricesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxProfitMy1(kSet[i], pricesSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProfit My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < pricesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxProfitAnswer1(kSet[i], pricesSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProfit Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
