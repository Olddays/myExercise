package com.liu.LeetCode.CodeCaprice.DP;

public class LC714_BestTimeToBuyAndSellStockWithTransactionFee {

    // Beats 39.56%
    private static int maxProfitMy1(int[] prices, int fee) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        // dp[i][j] 表示在i天股票状态为j时的最大利润
        // j 只有两种状态 0: 持有股票 1: 不持有股票
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0] - fee; // 持有股票，那就是负的;
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[length - 1][1];
    }

    private static int maxProfitAnswer1(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, price + buy - fee);
        }
        return sell;
    }

    public static void main(String[] args) {
        int[][] pricesSet = new int[][]{
                {1, 3, 2, 8, 4, 9},
                {1, 3, 7, 5, 10, 3},
        };
        int[] feeSet = new int[]{
                2,
                3,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < pricesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxProfitMy1(pricesSet[i], feeSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProfit My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < pricesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxProfitAnswer1(pricesSet[i], feeSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProfit Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
