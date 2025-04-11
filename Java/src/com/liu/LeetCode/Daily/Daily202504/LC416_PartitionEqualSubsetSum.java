package com.liu.LeetCode.Daily.Daily202504;

import java.util.*;

public class LC416_PartitionEqualSubsetSum {

    // 转换成以恶搞背包问题
    private static boolean canPartitionMy1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int[] dp = new int[sum / 2 + 1];
        dp[0] = 0;
        for (int num : nums) {
            for (int j = sum / 2; j >= num; j--) { // 这里需要从大到小遍历，因为需要用到上一层的结果
                // 如果j不大于nums[i]，那么就不需要比较了，因为背包容量不够
                // 这里的dp[j]其实是上一层的dp[j]，而dp[j-nums[i-1]]+nums[i-1]是上一层的dp[j-nums[i-1]]+nums[i-1]
                // 这里的nums[i-1]是因为nums的下标是从0开始的，而dp的下标是从1开始的
                if (j - num >= 0) { // 避免越界
                    dp[j] = Math.max(dp[j], dp[j - num] + num);
                }
            }
        }
        return dp[sum / 2] == sum / 2;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1,5,11,5},
                {1,2,3,5},
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
    }
}
