package com.liu.LeetCode.ThirtyDays202007.exercise;

/**
 * Created by Liu on 2020/7/31.
 */
public class TD31_ClimbingStairs {
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
