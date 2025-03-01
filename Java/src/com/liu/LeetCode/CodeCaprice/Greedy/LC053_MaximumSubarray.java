package com.liu.LeetCode.CodeCaprice.Greedy;

public class LC053_MaximumSubarray {

    // 贪心，只要结果是负数，不如重新开始
    // Beats 99.52%
    private static int maxSubArrayMy1(int[] nums) {
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    // 动态规划。每个dp只保存当前位置的最大值，如果小于下一个数据那就直接重新开始
    // Beats 99.52%
    private static int maxSubArrayMy2(int[] nums) {
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
        long startTime;
        int result;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxSubArrayMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxSubArray My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxSubArrayMy2(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxSubArray My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
