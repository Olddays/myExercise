package com.liu.LeetCode.First.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 2017/9/30.
 */
public class LC581_ShortestUnsortedContinuousSubarray {
    /**
     * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
     * then the whole array will be sorted in ascending order, too.
     * <p>
     * You need to find the shortest such subarray and output its length.
     * <p>
     * Example 1:
     * <p>
     * Input: [2, 6, 4, 8, 10, 9, 15]
     * Output: 5
     * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
     * <p>
     * Note:
     * <p>
     * Then length of the input array is in range [1, 10,000].
     * The input array may contain duplicates, so ascending order here means <=.
     */

    // 无法处理2, 3, 1, 4, 5这种输入
    public static int getShortestUnsortedContinuousSubarrayMy1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Map<Integer, Integer> cache = new HashMap<>();
        int cacheNum = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[cacheNum]) {
                cache.put(cacheNum, i);
            } else {
                cacheNum = i;
            }
        }
        cacheNum = length - 1;
        for (int i = length - 2; i > 0; i--) {
            if (nums[cacheNum] < nums[i]) {
                cache.put(cacheNum, i);
            } else {
                cacheNum = i;
            }
        }
        if (cache.size() > 0) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
                min = Math.min(entry.getValue(), min);
                min = Math.min(entry.getKey(), min);
                max = Math.max(entry.getValue(), max);
                max = Math.max(entry.getKey(), max);
            }
            return max - min + 1;
        } else {
            return 0;
        }
    }

    // I use the variables beg and end to keep track of minimum subarray A[beg...end]
    //  which must be sorted for the entire array A to be sorted.
    // If end < beg < 0 at the end of the for loop,
    //  then the array is already fully sorted.
    public static int getShortestUnsortedContinuousSubarrayAnswer1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int begin = -1;
        int end = -2;
        int min = nums[length - 1];
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[length - 1 - i]);
            if (nums[i] < max) {
                end = i;
            }
            if (nums[length - 1 - i] > min) {
                begin = length - 1 - i;
            }
        }
        return end - begin + 1;
    }
}
