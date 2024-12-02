package com.liu.LeetCode.FifteenPatterns.DynamicProgrammingPatterns.ZeroOneKnapsack;

import java.util.Arrays;

/**
 * The 0/1 Knapsack pattern is useful when:
 * You have a set of items, each with a weight and a value.
 * You need to select a subset of these items.
 * There's a constraint on the total weight (or some other resource) you can use.
 * You want to maximize (or minimize) the total value of the selected items.
 * Each item can be chosen only once (hence the "0/1" - you either take it or you don't).
 */
public class LC416_PartitionEqualSubsetSum {

    // 无法处理 1，1，2，2
    private static boolean canPartitionMy1(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        Arrays.sort(nums);
        int leftSum = 0;
        int rightSum = 0;
        while (left <= right) {
            if (leftSum < rightSum) {
                leftSum += nums[left];
                left++;
            } else {
                rightSum += nums[right];
                right--;
            }
        }
        return leftSum == rightSum;
    }

    private static boolean canPartitionAnswer1(int[] nums) {
        int sum = Arrays.stream(nums)
                .boxed()
                .reduce(0, Integer::sum);
        if (sum % 2 != 0) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length + 1][(sum / 2) + 1];
        for (int i = 0; i < nums.length; ++i) {
            dp[i][0] = true;
        }
        for (int i = nums.length - 1; i >= 0; --i) {
            for (int j = 1; j <= sum / 2; ++j) {
                if (j - nums[i] >= 0) {
                    dp[i][j] = dp[i + 1][j - nums[i]];
                }
                dp[i][j] = dp[i][j] || dp[i + 1][j];
            }
        }
        return dp[0][sum / 2];
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {2, 2, 1, 1},
                {2, 2, 3, 4},
                {1, 5, 11, 5},
                {1, 2, 3, 5},
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = canPartitionMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("canPartition My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = canPartitionAnswer1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("canPartition Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
