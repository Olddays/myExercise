package com.liu.LeetCode.FifteenPatterns.DynamicProgrammingPatterns.KadanesAlgorithm;

/**
 * Kadane's Algorithm is primarily used for solving the Maximum Subarray Problem and its variations where the problem asks to optimize a contiguous subarray within a one-dimensional numeric array
 * https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d
 */
public class LC053_MaximumSubarray {
    private static int maxSubArrayMy1(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {-2, 1, -3, 4, -1, 2, 1, -5, 4},
                {1},
                {5, 4, -1, 7, 8},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxSubArrayMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxSubArray My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
