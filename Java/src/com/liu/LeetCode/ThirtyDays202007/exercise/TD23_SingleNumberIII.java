package com.liu.LeetCode.ThirtyDays202007.exercise;

import java.util.Arrays;

/**
 * Created by Liu on 2020/7/23.
 */
public class TD23_SingleNumberIII {
    public static int[] singleNumber(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return nums;
        }
        Arrays.sort(nums);
        int x = nums[0];
        int i = 0;
        while (nums[i + 1] == nums[i]) {
            i++;
        }
        if (i > 0) {
            for (; i < length - 1; i++) {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    x = nums[i];
                    break;
                }
            }
        }
        i++;
        int y = nums[length - 1];
        for (; i < length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                y = nums[i];
            }
        }
        return new int[]{x, y};
    }
}
