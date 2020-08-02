package com.liu.LeetCode.ThirtyDays202007.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2020/7/13.
 */
public class TD11_Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubset(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void findSubset(List<List<Integer>> result, ArrayList<Integer> cache, int[] nums, int start) {
        if (!result.contains(cache)) {
            result.add(new ArrayList<>(cache));
        }
        for (int i = start; i < nums.length; i++) {
            cache.add(nums[i]);
            findSubset(result, cache, nums, i + 1);
            cache.remove(cache.size() - 1);
        }
    }
}
