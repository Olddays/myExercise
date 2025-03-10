package com.liu.LeetCode.CodeCaprice.DP.Subsequence;

import java.util.Arrays;

public class LC300_LongestIncreasingSubsequence {

    // Beats 51.78%
    private static int lengthOfLISMy1(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        // dp[i] 表示以num[i]结尾的最长递增子序列的长度
        int[] dp = new int[length];
        // 初始化要注意，并不是0，而是1，因为每个数字本身就是一个长度为1的递增子序列
        Arrays.fill(dp, 1);
        // dp[i]的定义是以num[i]结尾的最长递增子序列的长度，所以不一定最后一个数字是最大的，所以需要一个保存最大值
        int maxLength = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[][] pricesSet = new int[][]{
                {10, 9, 2, 5, 3, 7, 101, 18},
                {4, 10, 4, 3, 8, 9},
                {0, 1, 0, 3, 2, 3},
                {7, 7, 7, 7, 7, 7, 7},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < pricesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = lengthOfLISMy1(pricesSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("lengthOfLIS My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
