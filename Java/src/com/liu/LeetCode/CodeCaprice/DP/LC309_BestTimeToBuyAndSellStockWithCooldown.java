package com.liu.LeetCode.CodeCaprice.DP;

public class LC309_BestTimeToBuyAndSellStockWithCooldown {

    // Beats 79.58%
    private static int maxProfitMy1(int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        // dp[i][j] 表示在i天股票状态为j时的最大利润
        // j 有三种状态 0: 持有股票 1: 不持有股票 2: 冷冻期
        int[][] dp = new int[length][3];
        dp[0][0] = -prices[0]; // 持有股票，那就是负的
        dp[0][1] = 0; // 不持有股票，那就是0
        dp[0][2] = 0; // 冷冻期，那就是0
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]); // 要么保持之前的状态，要么是之前不持有股票现在买了，买了就得花钱，那就是从冷冻期基础上负的
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]); // 不持有股票，那就是前一天冷冻期或者前一天持有股票，冷冻期和不持有一样，所以选冷冻期即可
            dp[i][2] = dp[i - 1][1]; // 冷冻期，那就是前一天不持有股票
        }
        return dp[length - 1][1]; // 最后返回卖掉股票的状态
    }

    // Beats 17.38%
    // 状态更加清晰，但是会慢一些
    private static int maxProfitAnswer1(int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        // dp[i][j] 表示在i天股票状态为j时的最大利润
        // j 有三种状态 0: 持有股票 1: 不持有股票且不冷冻 2: 不持有股票 3: 冷冻期
        int[][] dp = new int[length][4];
        dp[0][0] = -prices[0]; // 持有股票，那就是负的
        dp[0][1] = 0; // 不持有股票且不冷冻，那就是0
        dp[0][2] = 0; // 不持有股票，那就是0
        dp[0][3] = 0; // 冷冻期，那就是0
        for (int i = 1; i < length; i++) {
            // 要么保持之前的状态，要么是之前不持有股票现在买了，或者从冷冻期状态买了，买了就得花钱，那就是负的
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]), dp[i - 1][3] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]); // 不持有股票且不冷冻，要么保持之前一直没买的状态，要么是之前冷冻期
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + prices[i]); // 不持有股票，那就是前一天冷冻期或者前一天持有股票，冷冻期和不持有一样，所以选冷冻期即可
            dp[i][3] = dp[i - 1][2]; // 冷冻期，那就是前一天不持有股票
        }
        return dp[length - 1][2]; // 最后返回卖掉股票的状态
    }

    public static void main(String[] args) {
        int[][] pricesSet = new int[][]{
                {1, 4, 2},
                {1, 2, 3, 0, 2},
                {1},
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
            result = maxProfitAnswer1(pricesSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProfit Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
