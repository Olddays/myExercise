package com.liu.LeetCode.ThirtyDays202004.exercise;

public class TD03_MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] maxCount = new int[length];
        for (int i = 0; i < length; i++) {
            maxCount[i] = Integer.MIN_VALUE;
        }
        maxCount[0] = nums[0];
        for (int i = 1; i < length; i++) {
            maxCount[i] = Math.max(maxCount[i - 1] + nums[i], nums[i]);
        }
        int max = maxCount[0];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, maxCount[i]);
        }
        return max;
    }
}
