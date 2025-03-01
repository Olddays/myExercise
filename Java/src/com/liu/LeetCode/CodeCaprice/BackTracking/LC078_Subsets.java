package com.liu.LeetCode.CodeCaprice.BackTracking;

import java.util.*;

public class LC078_Subsets {
    // Beats 100.00%
    private static List<List<Integer>> subsetsMy1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackMy1(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrackMy1(List<List<Integer>> result, List<Integer> cache, int[] nums, int index) {
        result.add(new ArrayList<>(cache));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            cache.add(nums[i]);
            backtrackMy1(result, cache, nums, i + 1);
            cache.remove(cache.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 2, 3},
                {0},
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = subsetsMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("subsets My1 result" + i + " ");
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
