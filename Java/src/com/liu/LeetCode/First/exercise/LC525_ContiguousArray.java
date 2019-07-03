package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liu on 2017/9/30.
 */
public class LC525_ContiguousArray {
    /**
     * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
     * <p>
     * Example 1:
     * Input: [0,1]
     * Output: 2
     * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
     * Example 2:
     * Input: [0,1,0]
     * Output: 2
     * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
     * Note: The length of the given binary array will not exceed 50,000.
     */

    /**
     * Answer2 can be further simplified by using just one number to record the number of diffs
     * zero > 0 means we have more zeros than ones
     * zero < 0 means we have more ones than zeros
     * zero == 0 means we have equal number of ones and zeros
     * For example, if at any index i we have zero = 1, then we have 1 diff (1 more 0s than 1s),
     * we record it in the HashMap, and if later at index j we meet another situation that zero = 1,
     * this means from the index i till the index j, the number of 0s and 1s are the same.
     */
    public static int getContiguousArrayAnswer1(int[] nums) {
        int length = nums.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int zero = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else {
                zero--;
            }
            if (zero == 0) {
                result = i + 1;
            }
            if (!map.containsKey(zero)) {
                map.put(zero, i);
                // 用于记录每个可能的合的起始位置,比如前一个值能得到1,则有(1,1),前两个值能得到2,则有(2,2)
            } else {
                result = Math.max(result, i - map.get(zero));
                // 比如 前三个值得到了1,然后前五个值又得到了1,那么此时就可以认为有5-3=2,这两个值的合一定为0
            }
        }
        return result;
    }

    /**
     * The idea is to change 0 in the original array to -1.
     * Thus, if we find SUM[i, j] == 0 then we know there are even number of -1 and 1 between index i and j.
     * Also put the sum to index mapping to a HashMap to make search faster.
     */
    public static int getContiguousArrayAnswer2(int[] nums) {
        int length = nums.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) {
                result = Math.max(result, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }

        return result;
    }
}
