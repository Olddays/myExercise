package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC033_SearchInRotatedSortedArray {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * <p>
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * <p>
     * You may assume no duplicate exists in the array.
     */

    // ???居然就这么简单..?想太多了
    public static int getSearchInRotatedSortedArrayMy1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
