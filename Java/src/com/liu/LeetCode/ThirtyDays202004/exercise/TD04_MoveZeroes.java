package com.liu.LeetCode.ThirtyDays202004.exercise;

public class TD04_MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (nums[j] == 0) {
                    j++;
                    if (j >= length) {
                        return;
                    }
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }
}
