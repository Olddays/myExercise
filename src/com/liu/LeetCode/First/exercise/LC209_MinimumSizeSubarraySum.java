package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC209_MinimumSizeSubarraySum {
    /**
     * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
     * <p>
     * For example, given the array [2,3,1,2,4,3] and s = 7,
     * the subarray [4,3] has the minimal length under the problem constraint.
     * <p>
     * More practice:
     * <p>
     * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
     */

    // 时间复杂度太高了
    public static int getMinimumSizeSubarraySumMy1(int s, int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> mapCache = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int cache = s;
            List<Integer> listCache = new ArrayList<>();
            for (int j = i; j < length; j++) {
                if (cache > 0) {
                    cache -= nums[j];
                    listCache.add(nums[j]);
                } else {
                    break;
                }
            }
            if (cache <= 0) {
                mapCache.put(nums[i], listCache);
            }
        }
        int result = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : mapCache.entrySet()) {
            result = Math.min(result, entry.getValue().size());
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static int getMinimumSizeSubarraySumAnswer1(int s, int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int subEnd = 0;
        int subStart = 0;
        int subSum = 0;
        int minLength = Integer.MAX_VALUE;
        while (subEnd < length) {
            subSum += nums[subEnd++]; // 结尾往后挪
            while (subSum >= s) {
                minLength = Math.min(minLength, subEnd - subStart); // i-j表示目前计算的sum中的子串的开头与结尾的间距
                subSum -= nums[subStart++]; // 开头往挪挪
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
