package com.liu.LeetCode.FifteenPatterns.DynamicProgrammingPatterns.KadanesAlgorithm;

public class LC918_MaximumSumCircularSubarray {

    // error 无法处理循环的部分
    private static int maxSubarraySumCircularMy1(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length * 2];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < length * 2 - 1; i++) {
            int num = nums[i % length];
            if (i > length - 1) {
                dp[i] = Math.max(dp[i - 1] - dp[i - length] + num, num);
            } else {
                dp[i] = Math.max(dp[i - 1] + num, num);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static int maxSubarraySumCircularAnswer1(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int curMax = 0;
        int curMin = 0;
        int totalSum = 0;
        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
            totalSum += num;
        }
        return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {5, -3, 5},
                {1, -2, 3, -2},
                {-3, -2, -3},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxSubarraySumCircularMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxSubarraySumCircular My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxSubarraySumCircularAnswer1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxSubarraySumCircular Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
