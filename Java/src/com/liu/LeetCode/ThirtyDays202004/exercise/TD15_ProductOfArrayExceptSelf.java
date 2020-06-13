package com.liu.LeetCode.ThirtyDays202004.exercise;

public class TD15_ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return nums;
        }
        int product = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }
        for (int i = 0; i < length; i++) {
            if (zeroCount > 1) {
                nums[i] = 0;
            } else if (zeroCount == 1) {
                if (nums[i] == 0) {
                    nums[i] = product;
                } else {
                    nums[i] = 0;
                }
            } else {
                nums[i] = product / nums[i];
            }
        }
        return nums;
    }
}
