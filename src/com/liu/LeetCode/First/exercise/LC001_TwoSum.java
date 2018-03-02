package com.liu.LeetCode.First.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 2017/9/6.
 */
public class LC001_TwoSum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */


    public static int[] getTwoSumMy1(int[] nums, int target) {
        Map<Integer, Integer> cacheMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (null != cacheMap.get(target - nums[i])) {
                return new int[]{cacheMap.get(target - nums[i]), i};
            } else {
                cacheMap.put(nums[i], i);
            }
        }
        return null;
    }
}
