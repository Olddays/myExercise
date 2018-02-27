package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC153_FindMinimumInRotatedSortedArray {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * <p>
     * Find the minimum element.
     * <p>
     * You may assume no duplicate exists in the array.
     */

    public static int getFindMinimumInRotatedSortedArrayMy1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int result = nums[0];
        for (int i = 1; i < length; i++) {
            if (result > nums[i]) {
                return nums[i];
            }
        }
        return result;
    }
}
