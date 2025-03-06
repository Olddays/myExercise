package com.liu.LeetCode.CodeCaprice.DP.PackageFull;

public class LC322_CoinChange {
    // Beats 95.37%
    private static int coinChangeMy1(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // dp表示在amount为i时的最少硬币数
        dp[0] = 0; // amount为0时，不需要硬币
        for (int i = 1; i <= amount; i++) {
            // 因为要计算Min，所以初始化为尽可能大的值，如果使用Integer最大值可能会在+1的时候越界成为最小值
            // 所以使用amount + 1作为最大值，因为dp的数据绝对不会超过amount，最多等于amount
            dp[i] = amount + 1;
        }
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);// 状态转移方程
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[][] coinSet = new int[][]{
                {1, 2, 5},
                {2},
                {1},
        };
        int[] amountSet = new int[]{
                11,
                3,
                0,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < coinSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = coinChangeMy1(coinSet[i], amountSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("coinChange My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
