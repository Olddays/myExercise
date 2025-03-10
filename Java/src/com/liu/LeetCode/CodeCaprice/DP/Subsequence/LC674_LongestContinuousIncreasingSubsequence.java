package com.liu.LeetCode.CodeCaprice.DP.Subsequence;

import java.util.Arrays;

public class LC674_LongestContinuousIncreasingSubsequence {

    // Beats 100.00%
    private static int findLengthOfLCISMy1(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        int pre = nums[0];
        int max = 0;
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] > pre) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
            pre = nums[i];
        }
        max = Math.max(max, count);
        return max;
    }

    // dp
    // Beats 5.12%
    private static int findLengthOfLCISMy2(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] pricesSet = new int[][]{
                {1, 3, 5, 7},
                {1, 3, 5, 4, 7},
                {2, 2, 2, 2, 2},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < pricesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = findLengthOfLCISMy1(pricesSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findLengthOfLCIS My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < pricesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = findLengthOfLCISMy2(pricesSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findLengthOfLCIS My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
