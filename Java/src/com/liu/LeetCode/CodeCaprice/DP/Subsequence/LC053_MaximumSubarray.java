package com.liu.LeetCode.CodeCaprice.DP.Subsequence;

public class LC053_MaximumSubarray {

    // Beats 99.47%
    private static int maxSubArrayMy1(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {-2, 1, -3, 4, -1, 2, 1, -5, 4},
                {1},
                {5, 4, -1, 7, 8},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxSubArrayMy1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxSubArray My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
