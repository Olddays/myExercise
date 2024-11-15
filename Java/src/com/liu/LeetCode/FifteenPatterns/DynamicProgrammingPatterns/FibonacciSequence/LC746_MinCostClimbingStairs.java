package com.liu.LeetCode.FifteenPatterns.DynamicProgrammingPatterns.FibonacciSequence;

public class LC746_MinCostClimbingStairs {
    private static int minCostClimbingStairsMy1(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 100, 1, 1, 1, 100, 1, 1, 100, 1},
                {10, 15, 20},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minCostClimbingStairsMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minCostClimbingStairs My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }

}
