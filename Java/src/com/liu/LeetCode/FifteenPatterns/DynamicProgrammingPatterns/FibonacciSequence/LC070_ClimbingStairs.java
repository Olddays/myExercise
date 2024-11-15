package com.liu.LeetCode.FifteenPatterns.DynamicProgrammingPatterns.FibonacciSequence;

/**
 * The Fibonacci sequence pattern is useful when the solution to a problem depends on the solutions of smaller instances of the same problem.
 * There is a clear recursive relationship, often resembling the classic Fibonacci sequence F(n) = F(n-1) + F(n-2).
 * https://en.wikipedia.org/wiki/Fibonacci_sequence
 */
public class LC070_ClimbingStairs {

    private static int climbStairsMy1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
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
            result = climbStairsMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("climbStairs My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }

}
