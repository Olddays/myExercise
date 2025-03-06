package com.liu.LeetCode.CodeCaprice.DP;

public class LC746_MinCostClimbingStairs {

    private static int minCostClimbingStairsMy1(int[] cost) {
        int n = cost.length;
        // dp[i] 表示爬到第i阶楼梯的最小花费,i表示楼梯的层数
        int[] dp = new int[n + 1];
        dp[0] = cost[0]; // 第0个台阶
        dp[1] = cost[1]; // 第1个台阶
        for (int i = 2; i < n; i++) { // <n 是因为dp[n]是楼顶, 所以不需要计算
            // 第i个台阶的最小花费为 第i-1个台阶的最小花费 和 第i-2个台阶的最小花费 中较小的那个 + 第i个台阶的花费
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[n - 1], dp[n - 2]); // 最后两步，看谁小
    }

    public static void main(String[] args) {
        int[][] costSet = new int[][]{
                {10, 15, 20},
                {1, 100, 1, 1, 1, 100, 1, 1, 100, 1},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < costSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = minCostClimbingStairsMy1(costSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minCostClimbingStairs My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
