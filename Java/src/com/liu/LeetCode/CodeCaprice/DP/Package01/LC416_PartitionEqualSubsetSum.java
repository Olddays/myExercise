package com.liu.LeetCode.CodeCaprice.DP.Package01;

import java.util.*;

public class LC416_PartitionEqualSubsetSum {

    // error
    private static boolean canPartitionMyError1(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = length - 1;
        int leftSum = 0;
        int rightSum = 0;
        while (left < right) {
            // 这个会错误，在  1，3，4，4这种情况下会出错，无法完整遍历且sum的更新不及时
            int leftCache = leftSum + nums[left];
            int rightCache = rightSum + nums[right];
            if (leftCache == rightCache) {
                left++;
                leftSum = leftCache;
                right--;
                rightSum = rightCache;
            } else if (leftCache > rightCache) {
                right--;
                rightSum = rightCache;
            } else {
                left++;
                leftSum = leftCache;
            }
        }
        return leftSum == rightSum;
    }

    // Beats 37.50%
    private static boolean canPartitionMy1(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        } // 通过sum，转换为一个背包问题，因为转化成了背包问题，那就不需要排序了
        if (sum % 2 != 0) { // 如果不能平分就不用继续了
            return false;
        }
        // dp[i][j]表示前i个元素，背包容量为j时，是否可以凑成总和为j的子集，也就是能不能填满背包
        boolean[][] dp = new boolean[length + 1][sum / 2 + 1];
        // 初始化，背包容量为0时，都可以填满，也就是总有子集可以将空间为0的背包填满，也就是不装任何东西的空数组
        for (int i = 0; i <= length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                }
                dp[i][j] = dp[i][j] || dp[i - 1][j];
            }
        }

        return dp[length][sum / 2];
    }

    // Beats 85.82%
    private static boolean canPartitionAnswer1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        } // 通过sum，转换为一个背包问题，因为转化成了背包问题，那就不需要排序了
        if (sum % 2 != 0) { // 如果不能平分就不用继续了
            return false;
        }
        // dp[i][j]表示前i个元素，背包容量为j时，背包能填满的最大值
        int[] dp = new int[sum / 2 + 1];
        // 初始化，背包容量为0时
        dp[0] = 0;
        // 递推公式 dp[j] = max(dp[j], dp[j-nums[i-1]]+nums[i-1])
        for (int num : nums) {
            for (int j = sum / 2; j >= num; j--) { // 这里需要从大到小遍历，因为需要用到上一层的结果
                // 如果j不大于nums[i]，那么就不需要比较了，因为背包容量不够
                // 这里的dp[j]其实是上一层的dp[j]，因为运行完这个位置 才会更新，而dp[j-nums[i-1]]+nums[i-1]是上一层的dp[j-nums[i-1]]+nums[i-1]
                // 这里的nums[i-1]是因为nums的下标是从0开始的，而dp的下标是从1开始的
                dp[j] = Math.max(dp[j],  dp[j - num] + num);
            }
        }

        return dp[sum / 2] == sum / 2;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {1, 5, 11, 5},
                {1, 3, 4, 4},
                {1},
                {1, 2, 3, 5},
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = canPartitionMy1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("canPartition My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = canPartitionAnswer1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("canPartition Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
