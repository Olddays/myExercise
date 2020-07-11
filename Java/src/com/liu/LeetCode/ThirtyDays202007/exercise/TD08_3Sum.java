package com.liu.LeetCode.ThirtyDays202007.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Liu on 2020/7/8.
 */
public class TD08_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int left = 0; left < length - 2; left++) {
            if (left != 0 && nums[left] == nums[left - 1]) {
                continue; // to skip duplicate number; e.g [0, 0, 0, 0]
            }
            int mid = left + 1;
            int right = nums.length - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0) {
                    List<Integer> cache = new ArrayList<>();
                    cache.add(nums[left]);
                    cache.add(nums[mid]);
                    cache.add(nums[right]);
                    result.add(cache);
                    mid++;
                    right--;
                    while (mid < right && nums[right + 1] == nums[right]) {
                        right--; // 跳过重复项 此时不可以比较nums[right - 1] == nums[right],因为nums[right - 1]还没有进行判断,会出现丢失数据的问题
                    }
                    while (mid < right && nums[mid - 1] == nums[mid]) {
                        mid++; // 跳过重复项 此时不可以比较nums[left + 1] == nums[left],因为nums[left + 1]还没有进行判断,会出现丢失数据的问题
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        return result;
    }
}
