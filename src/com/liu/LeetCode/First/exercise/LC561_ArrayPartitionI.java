package com.liu.LeetCode.First.exercise;

import java.util.Arrays;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC561_ArrayPartitionI {
    /**
     * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,4,3,2]
     * <p>
     * Output: 4
     * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
     * <p>
     * Note:
     * <p>
     * n is a positive integer, which is in the range of [1, 10000].
     * All the integers in the array will be in the range of [-10000, 10000].
     */

    public static int getArrayPartitionIMy1(int[] nums) {
        int length = nums.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}
