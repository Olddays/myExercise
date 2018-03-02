package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liu on 2017/9/14.
 */
public class LC015_ThreeSum {
    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     * <p>
     * Note: The solution set must not contain duplicate triplets.
     */


    public static List<List<Integer>> getThreeSumMy1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue; // to skip duplicate number; e.g [0, 0, 0, 0]
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> cache = new ArrayList<>();
                    cache.add(nums[i]);
                    cache.add(nums[left]);
                    cache.add(nums[right]);
                    result.add(cache);
                    left++;
                    right--;
                    while (left < right && nums[right + 1] == nums[right]) {
                        right--; // 跳过重复项 此时不可以比较nums[right - 1] == nums[right],因为nums[right - 1]还没有进行判断,会出现丢失数据的问题
                    }
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++; // 跳过重复项 此时不可以比较nums[left + 1] == nums[left],因为nums[left + 1]还没有进行判断,会出现丢失数据的问题
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
