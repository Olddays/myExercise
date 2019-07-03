package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC485_MaxConsecutiveOnes {
    /**
     * Given a binary array, find the maximum number of consecutive 1s in this array.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,1,0,1,1,1]
     * Output: 3
     * Explanation: The first two digits or the last three digits are consecutive 1s.
     * The maximum number of consecutive 1s is 3.
     * <p>
     * Note:
     * <p>
     * The input array will only contain 0 and 1.
     * The length of input array is a positive integer and will not exceed 10,000
     */

    public static int getMaxConsecutiveOnesMy1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int max = 0;
        int cache = 0;
        for (int num : nums) {
            if (num == 1) {
                cache++;
            } else {
                max = Math.max(max, cache);
                cache = 0;
            }
        }
        if (cache > 0) {
            max = Math.max(max, cache);
        }
        return max;
    }
}
