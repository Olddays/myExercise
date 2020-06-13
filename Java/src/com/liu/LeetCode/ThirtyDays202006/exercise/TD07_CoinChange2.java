package com.liu.LeetCode.ThirtyDays202006.exercise;

/**
 * Created by Liu on 2020/6/7.
 */
public class TD07_CoinChange2 {
    private static int result = 0;

    // TimeLimited
    public static int changeMy1(int amount, int[] coins) {
        result = 0;
        int length = coins.length;
        doCheck(amount, coins, length, 0, 0);
        return result;
    }

    private static void doCheck(int amount, int[] coins, int length, int start, int nowCount) {
        if (nowCount == amount) {
            result++;
        } else if (nowCount < amount) {
            for (int i = start; i < length; i++) {
                doCheck(amount, coins, length, i, nowCount + coins[i]);
            }
        }
    }

    public static int changeMy2(int amount, int[] coins) {
        int length = coins.length;
        int[][] dp = new int[length + 1][amount + 1];
        for (int i = 1; i < length + 1; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < amount + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public static int changeAnswer1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
