package com.liu.LeetCode.CodeCaprice.DP;

public class LCC509_FibonacciNumber {

    private static int fibMy1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nSet = new int[]{
                1,
                2,
                3,
                4,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = fibMy1(nSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("fib My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
