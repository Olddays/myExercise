package com.liu.LeetCode.FifteenPatterns.DynamicProgrammingPatterns.FibonacciSequence;

public class LC509_FibonacciNumber {

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
        int[] numsList = new int[]{
                2,
                3,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = fibMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("fib My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }

}
