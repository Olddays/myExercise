package com.liu.LeetCode.First.exercise;

import java.util.Arrays;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC217_ContainsDuplicate {
    /**
     * Given an array of integers, find if the array contains any duplicates.
     * Your function should return true if any value appears at least twice in the array,
     * and it should return false if every element is distinct.
     */

    public static boolean getContainsDuplicateMy1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return false;
        }
        Arrays.sort(nums); // 时间复杂度为nlog(n)
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
