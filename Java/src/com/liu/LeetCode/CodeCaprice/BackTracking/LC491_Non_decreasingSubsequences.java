package com.liu.LeetCode.CodeCaprice.BackTracking;

import java.util.*;

public class LC491_Non_decreasingSubsequences {

    // 无法处理1,2,1,1,1这种情况，缺少去重
    private static List<List<Integer>> findSubsequencesMy1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackMy1(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrackMy1(List<List<Integer>> result, List<Integer> cache, int[] nums, int index) {
        if (cache.size() > 1) {
            result.add(new ArrayList<>(cache));
        }
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                // 要处理一下1,2,1,1,1这种情况下，a（1,1,1,1）和b（1,1,1）会重复计算，因为a里面第一个1的index是0，不会进入此判断
                continue;
            }
            if (!cache.isEmpty() && cache.get(cache.size() - 1) > nums[i]) {
                continue;
            }
            cache.add(nums[i]);
            backtrackMy1(result, cache, nums, i + 1);
            cache.remove(cache.size() - 1);
        }
    }

    // Beats 60.98%
    private static List<List<Integer>> findSubsequencesMy2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackMy2(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrackMy2(List<List<Integer>> result, List<Integer> cache, int[] nums, int index) {
        if (cache.size() > 1) {
            result.add(new ArrayList<>(cache));
        }
        if (index == nums.length) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                // 要处理一下1,2,1,1,1这种情况下，a（1,1,1,1）和b（1,1,1）会重复计算，因为a里面第一个1的index是0，不会进入此判断
                continue;
            }
            if (!cache.isEmpty() && cache.get(cache.size() - 1) > nums[i] || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            cache.add(nums[i]);
            backtrackMy2(result, cache, nums, i + 1);
            cache.remove(cache.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 2, 1, 1, 1},
                {4, 6, 7, 7},
                {4, 4, 3, 2, 1},
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = findSubsequencesMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("findSubsequences My1 result" + i + " ");
            for (List<Integer> list : result) {
                for (int val : list) {
                    System.out.print(val + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = findSubsequencesMy2(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("findSubsequences My2 result" + i + " ");
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
