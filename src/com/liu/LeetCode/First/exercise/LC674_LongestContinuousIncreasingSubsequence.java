package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC674_LongestContinuousIncreasingSubsequence {
    /**
     * Given an unsorted array of integers, find the length of longest continuous increasing subsequence.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,3,5,4,7]
     * Output: 3
     * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
     * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
     * <p>
     * Example 2:
     * <p>
     * Input: [2,2,2,2,2]
     * Output: 1
     * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
     * <p>
     * Note: Length of the array will not exceed 10,000.
     */

    // 整体思路还行,但是错了,而且写法超级傻
    public static int getLongestContinuousIncreasingSubsequenceMy1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int result = 1;
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                result = Math.max(count, result);
                count = 1;
            }
        }
        result = Math.max(count, result);
        return result;
    }
}
