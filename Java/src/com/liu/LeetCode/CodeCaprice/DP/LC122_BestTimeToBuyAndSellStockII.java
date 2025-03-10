package com.liu.LeetCode.CodeCaprice.DP;

public class LC122_BestTimeToBuyAndSellStockII {

    // Beats 76.91%
    private static int maxProfitMy1(int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        // DP[i] 表示到第i天累计的最大利润
        int[] dp = new int[length];
        dp[0] = 0;
        for (int i = 1; i < length; i++) {
            dp[i] = dp[i - 1];
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                dp[i] += diff;
            }
        }
        return dp[length - 1];
    }

    private static int maxProfitMy2(int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        // dp[i][j] 表示在i天股票状态为j时的最大利润
        // j 只有两种状态 0: 持有股票 1: 不持有股票
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            // 没买就是状态0，买了就是状态1
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]); // 要么保持之前的状态，要么是之前没买现在买了，买了就得花钱，那就是负的
            // 因为买卖多次，此时应该是不持有股票的状态减去当前的股票价格，所以是dp[i - 1][1] - prices[i]
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]); // 要么保持之前的状态，要么卖出股票
        }
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }

    public static void main(String[] args) {
        int[][] pricesSet = new int[][]{
                {7, 1, 5, 3, 6, 4},
                {1, 2, 3, 4, 5},
                {7, 6, 4, 3, 1},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < pricesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxProfitMy1(pricesSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProfit My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < pricesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxProfitMy2(pricesSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProfit My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
