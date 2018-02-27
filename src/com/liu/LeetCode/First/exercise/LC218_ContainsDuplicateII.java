package com.liu.LeetCode.First.exercise;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC218_ContainsDuplicateII {
    /**
     * Given an array of integers and an integer k,
     * find out whether there are two distinct indices i and j in the array
     * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
     */

    // 这里怎么修改都没有意义,错在i <= length - k + 1, length不一定大于k
    public static boolean getContainsDuplicateIIMy1(int[] nums, int k) {
        int length = nums.length;
        if (length <= 1) {
            return false;
        }
        for (int i = 0; i <= length - k + 1; i++) {
            for (int j = 1; j <= k; j++) {
                if (nums[i] == nums[i + j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean getContainsDuplicateIIMy2(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return false;
        }
        // 其实也可以用HashSet减少部分内存占用
        Map<Integer, Integer> cache = new HashMap<>(); // key: num, value: local
        for (int i = 0; i < length; i++) {
            if (cache.containsKey(nums[i])) {
                if (i - cache.get(nums[i]) <= k) {
                    return true;
                }
            }
            cache.put(nums[i], i);
        }
        return false;
    }
}
