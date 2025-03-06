package com.liu.LeetCode.CodeCaprice.DP.PackageFull;

public class LC279_PerfectSquares {

    // Beats 88.79%
    private static int numSquaresMy1(int n) {
        int[] dp = new int[n + 1]; // dp[i]表示数字i的完全平方数的最少数量
        dp[0] = 0; // 数字0的完全平方数的最少数量为0
        for (int i = 1; i <= n; i++) {
            dp[i] = n + 1; // 因为要计算min，所以初始化为最大值，为了避免+1时出现越界，不使用Integer.MAX_VALUE
        }
        for (int i = 1; i * i <= n; i++) { // 物品
            int square = i * i;
            for (int j = square; j <= n; j++) { // 背包
                dp[j] = Math.min(dp[j], dp[j - square] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nSet = new int[]{
                12,
                13,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = numSquaresMy1(nSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numSquares My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
