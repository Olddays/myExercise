package com.liu.LeetCode.CodeCaprice.BackTracking;

import java.util.*;

public class LC047_PermutationsII {

    // Beats 99.88%
    private static List<List<Integer>> permuteUniqueMy1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrackMy1(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrackMy1(List<List<Integer>> result, List<Integer> cache, int[] nums, boolean[] used) {
        if (cache.size() == nums.length) {
            result.add(new ArrayList<>(cache));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
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
                {1, 1, 3},
                {1, 2, 3},
                {1},
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = permuteUniqueMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("permuteUnique My1 result" + i + " ");
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
