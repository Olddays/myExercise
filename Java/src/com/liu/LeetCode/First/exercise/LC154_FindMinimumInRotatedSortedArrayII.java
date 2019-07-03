package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC154_FindMinimumInRotatedSortedArrayII {
    /**
     * Follow up for "Find Minimum in Rotated Sorted Array":
     * What if duplicates are allowed?
     * <p>
     * Would this affect the run-time complexity? How and why?
     * <p>
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * <p>
     * Find the minimum element.
     * <p>
     * The array may contain duplicates.
     */

    public static int getFindMinimumInRotatedSortedArrayIIMy1(int[] nums) {
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
