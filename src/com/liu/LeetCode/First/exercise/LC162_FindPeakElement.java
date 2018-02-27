package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC162_FindPeakElement {
    /**
     * A peak element is an element that is greater than its neighbors.
     * <p>
     * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
     * <p>
     * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
     * <p>
     * You may imagine that num[-1] = num[n] = -∞.
     * <p>
     * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
     * <p>
     * click to show spoilers.
     * <p>
     * Credits:
     * Special thanks to @ts for adding this problem and creating all test cases.
     */

    public static int getFindPeakElementMy1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i - 1;
            }
        }
        return length - 1;
    }
}
