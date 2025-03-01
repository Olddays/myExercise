package com.liu.LeetCode.CodeCaprice.BackTracking;

import java.util.*;

public class LC046_Permutations {
    // Beats 93.03%
    // 如果需要在一个集合里取元素，那么就需要一个used数组来标记
    private static List<List<Integer>> permuteMy1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackMy1(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrackMy1(List<List<Integer>> result, List<Integer> cache, int[] nums, boolean[] used) {
        if (cache.size() == nums.length) {
            result.add(new ArrayList<>(cache));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            cache.add(nums[i]);
            used[i] = true;
            backtrackMy1(result, cache, nums, used);
            used[i] = false;
            cache.remove(cache.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 2, 3},
                {0, 1},
                {1},
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = permuteMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("permute My1 result" + i + " ");
            for (List<Integer> list : result) {
                for (int val : list) {
                    System.out.print(val + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
