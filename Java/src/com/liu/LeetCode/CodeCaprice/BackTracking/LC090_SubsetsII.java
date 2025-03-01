package com.liu.LeetCode.CodeCaprice.BackTracking;

import java.util.*;

public class LC090_SubsetsII {
    // Beats 99.81%
    private static List<List<Integer>> subsetsWithDupMy1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrackMy1(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrackMy1(List<List<Integer>> result, List<Integer> cache, int[] nums, int index) {
        result.add(new ArrayList<>(cache));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            cache.add(nums[i]);
            backtrackMy1(result, cache, nums, i + 1);
            cache.remove(cache.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 2, 2},
                {0},
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = subsetsWithDupMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("subsetsWithDup My1 result" + i + " ");
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
