package com.liu.LeetCode.CodeCaprice.DP;

public class LC121_BestTimeToBuyAndSellStock {

    // Beats 7.22%
    private static int maxProfitMy1(int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        // DP[i] 表示第i天卖出的最大利润
        int[] dp = new int[length];
        dp[0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < length; i++) {
            // 要么等于前一天的利润，要么等于今天价格减去之前的最小价格
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return dp[length - 1];
    }

    // Beats 74.67%
    // 压缩掉数组，因为只有一个值需要更新和记录
    private static int maxProfitMy2(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }
            profit = Math.max(profit, prices[i] - buyPrice);
        }
        return profit;
    }

    private static int maxProfitMy3(int[] prices) {
        // dp[i][j] 表示在i天股票状态为j时的最大利润
        // j 只有两种状态 0: 持有股票 1: 不持有股票
        int length = prices.length;
        int[][] dp = new int[length][2];
        // 核心是保持买或卖的状态，而不一定在最后一天有没有卖，只关心状态即可，因为最终的结果不一定是啥样的
        // 不持有不一定是i天卖了，也可以是之前卖了
        dp[0][0] = -prices[0]; // 持有股票，那就是负的
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            // 没买就是状态0，买了就是状态1
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]); // 要么保持之前的状态，要么是之前没买现在买了，买了就得花钱，那就是负的，直接使用-prices[i]，只卖买一次，所以肯定是0-prices[i]
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]); // 要么保持之前的状态，要么卖出股票
        }
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }

    public static void main(String[] args) {
        int[][] pricesSet = new int[][]{
                {7, 1, 5, 3, 6, 4},
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

        for (int i = 0; i < pricesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxProfitMy3(pricesSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProfit My3 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
