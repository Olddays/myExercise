package com.liu.LeetCode.CodeCaprice.DP;

public class LC070_ClimbingStairs {
    private static int climbStairsMy1(int n) {
        if (n == 1) {
            return 1;
        }
        // dp[i] 表示爬到第i层楼梯的方法数,i表示楼梯的层数
        int[] dp = new int[n + 1];
        // dp[0]无意义
        dp[1] = 1;
        dp[2] = 2;
        // 递推公式
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nSet = new int[]{
                2,
                3,
                45,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = climbStairsMy1(nSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("climbStairs My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
