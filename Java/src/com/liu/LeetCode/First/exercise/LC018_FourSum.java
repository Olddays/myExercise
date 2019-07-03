package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liu on 2017/9/14.
 */
public class LC018_FourSum {
    /**
     * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
     * <p>
     * Note: The solution set must not contain duplicate quadruplets.
     */


    public static List<List<Integer>> getFourSumMy1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue; // to skip duplicate number; e.g [0, 0, 0, 0]
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> cache = new ArrayList<>();
                        cache.add(nums[i]);
                        cache.add(nums[j]);
                        cache.add(nums[left]);
                        cache.add(nums[right]);
                        if (!result.contains(cache)) {
                            result.add(cache); // 跳过已加入的重复项
                        }
                        left++;
                        right--;
                        while (left < right && nums[right + 1] == nums[right]) {
                            right--; // 跳过重复项 此时不可以比较nums[right - 1] == nums[right],因为nums[right - 1]还没有进行判断,会出现丢失数据的问题
                        }
                        while (left < right && nums[left - 1] == nums[left]) {
                            left++; // 跳过重复项 此时不可以比较nums[left + 1] == nums[left],因为nums[left + 1]还没有进行判断,会出现丢失数据的问题
                        }
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
