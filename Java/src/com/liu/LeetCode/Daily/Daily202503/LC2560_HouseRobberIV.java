package com.liu.LeetCode.Daily.Daily202503;

import java.util.Arrays;

public class LC2560_HouseRobberIV {

    // 核心是找到k个不连续的最小值
    // Beats 19.40%
    private static int minCapabilityMy1(int[] nums, int k) {
        int left = Arrays.stream(nums).min().getAsInt(); // 最小值
        int right = Arrays.stream(nums).max().getAsInt(); // 最大值

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canStealKHouses(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canStealKHouses(int[] nums, int k, int capability) {
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= capability) { // 这里简单的可以这么判断，是因为题目说一定有解
                count++;
                i += 2; // 利用贪心，直接选择小于能力mid的房子，并跳过相邻的房子，因为我们知道最后算出来的能力capability一定是最小的
            } else {
                i++;
            }
        }
        return count >= k; // 如果以mid作为能力值，可以偷大于等于k个房子，那么就继续在right（更大）的进行搜索，否则选left（小的一侧）
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {2, 3, 5, 9},
                {2, 7, 9, 3, 1},
        };
        int[] kSet = new int[]{
                2,
                2,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = minCapabilityMy1(numsSet[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minCapability My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
