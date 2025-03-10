package com.liu.LeetCode.CodeCaprice.DP;

public class LC123_BestTimeToBuyAndSellStockIII {

    // 只能进行两次交易，并且不能交叉
    private static int maxProfitMy1(int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        // dp[i][j] 表示在i天股票状态为j时的最大利润
        // j 只有五种状态 0: 未操作 1: 第一次持有股票 2: 第一次不持有股票 3: 第二次持有股票 4: 第二次不持有股票
        int[][] dp = new int[length][5];
        dp[0][0] = 0; // 还未操作
        dp[0][1] = -prices[0]; // 第一次买入
        dp[0][2] = 0; // 第一次卖出，也就是第一天买入第一天卖出
        dp[0][3] = -prices[0]; // 第二次买入，也就是第一天买入第一天卖出，再买入
        dp[0][4] = 0; // 第二次卖出
        // 那么递推公式就需要分别考虑
        for (int i = 1; i < length; i++) {
            dp[i][0] = dp[i - 1][0]; // 未操作，就一直是未操作，维持前面即可，所以这个状态可以省略
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); // 第一次买入操作，要么保持前面不变，要么从未操作进行-prices[i]的变更
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]); // 第一次卖出操作，要么保持前面不变，要么从第一次买入操作进行+prices[i]的变更
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]); // 第二次买入操作，要么保持前面不变，要么从第一次卖出操作进行-prices[i]的变更
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]); // 第二次卖出操作，要么保持前面不变，要么从第二次买入操作进行+prices[i]的变更
        }
        // 最后一定是第二次卖出结束，所以一定是dp[length - 1][4]
        return dp[length - 1][4];
    }

    public static void main(String[] args) {
        int[][] pricesSet = new int[][]{
                {3, 3, 5, 0, 0, 3, 1, 4},
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
    }
}
