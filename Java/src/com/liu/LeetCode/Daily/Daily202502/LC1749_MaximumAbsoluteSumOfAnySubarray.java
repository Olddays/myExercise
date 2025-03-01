package com.liu.LeetCode.Daily.Daily202502;

public class LC1749_MaximumAbsoluteSumOfAnySubarray {

    // Greedy，分别求最大和最小，然后比较一下他们的abs
    // Beats 71.69%
    private static int maxAbsoluteSumMy1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minSum = 0;
        int maxSum = 0;
        for (int num : nums) {
            maxSum += num;
            max = Math.max(max, maxSum);
            if (maxSum < 0) {
                maxSum = 0;
            }
            minSum += num;
            min = Math.min(min, minSum);
            if (minSum > 0) {
                minSum = 0;
            }
        }
        max = Math.max(max, -min);
        return max;
    }

    // DP
    // Beats 5.56%
    private static int maxAbsoluteSumMy2(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[2][length];
        dp[0][0] = nums[0];
        dp[1][0] = nums[0];
        int max = dp[0][0];
        int min = dp[1][0];
        for (int i = 1; i < length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[0][i]);
            dp[1][i] = Math.min(dp[1][i - 1] + nums[i], nums[i]);
            min = Math.min(min, dp[1][i]);
        }
        max = Math.max(max, -min);
        return max;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, -3, 2, 3, -4},
                {2, -5, 1, -4, 3, -2},
        };
        long startTime;
        int result;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxAbsoluteSumMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxAbsoluteSum My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxAbsoluteSumMy2(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxAbsoluteSum My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
