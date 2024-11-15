package com.liu.LeetCode.FifteenPatterns.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC078_Subsets {

    private static List<List<Integer>> subsetsMy1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        subsetTrackingMy1(result, list, nums, 0);
        return result;
    }

    private static void subsetTrackingMy1(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            subsetTrackingMy1(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {1, 2, 3},
                {0},
                {0, 1},
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = subsetsMy1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("subsets My1 result" + i + " ");
            for (List<Integer> nums : result) {
                for (int num : nums) {
                    System.out.print(num + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
