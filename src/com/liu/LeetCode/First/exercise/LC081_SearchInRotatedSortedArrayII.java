package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC081_SearchInRotatedSortedArrayII {
    /**
     * Follow up for "Search in Rotated Sorted Array":
     * What if duplicates are allowed?
     * <p>
     * Would this affect the run-time complexity? How and why?
     * <p>
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * <p>
     * Write a function to determine if a given target is in the array.
     * <p>
     * The array may contain duplicates.
     */

    public static boolean getSearchInRotatedSortedArrayIIMy1(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return false;
        }
        for (int n : nums) {
            if (target == n) {
                return true;
            }
        }
        return false;
    }
}
