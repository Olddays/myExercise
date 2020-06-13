package com.liu.LeetCode.ThirtyDays202005.exercise;

/**
 * Created by Liu on 2020/5/12.
 */
public class TD12_SingleElementInASortedArray {
    public static int singleNonDuplicateMy1(int[] nums) {
        int length = nums.length;
        int cache = nums[0];
        int count = 1;
        for (int i = 1; i < length - 1; i++) {
            int num = nums[i];
            if (cache == num) {
                count += 1;
            } else {
                if (count == 1) {
                    return cache;
                }
                count = 1;
                cache = num;
            }
        }
        return nums[length - 1];
    }

    public static int singleNonDuplicateMy2(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length / 2;
        while (left < right) {
            int m = (left + right) / 2;
            if (nums[2 * m] != nums[2 * m + 1]) {
                right = m;
            } else {
                left = m + 1;
            }
        }
        return nums[2 * left];
    }
}
