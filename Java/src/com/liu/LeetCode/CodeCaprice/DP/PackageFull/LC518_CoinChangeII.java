package com.liu.LeetCode.CodeCaprice.DP.PackageFull;

public class LC518_CoinChangeII {
    // Beats 92.72%
    private static int changeMy1(int amount, int[] coins) {
        int[] dp = new int[amount + 1]; // dp[i]表示金额为i时的组合数
        dp[0] = 1; // 金钱为0只有一种组合
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] amountSet = new int[]{
                5,
                3,
                10,
        };
        int[][] coinSet = new int[][]{
                {1, 2, 5},
                {2},
                {10},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < amountSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = changeMy1(amountSet[i], coinSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("change My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
