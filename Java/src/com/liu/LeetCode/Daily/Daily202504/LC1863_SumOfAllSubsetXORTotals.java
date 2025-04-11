package com.liu.LeetCode.Daily.Daily202504;

import java.util.ArrayList;
import java.util.List;

public class LC1863_SumOfAllSubsetXORTotals {

    // Beats 12.99%
    // 回溯算法遍历
    private static int subsetXORSumMy1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        subsetXORSumMy1Helper(nums, 0, list, new ArrayList<>());
        int result = 0;
        for (int num : list) {
            result += num;
        }
        return result;
    }

    private static void subsetXORSumMy1Helper(int[] nums, int index, List<Integer> list, List<Integer> cache) {
        int xor = 0;
        for (int num : cache) {
            xor ^= num;
        }
        list.add(xor);
        for (int i = index; i < nums.length; i++) {
            cache.add(nums[i]);
            subsetXORSumMy1Helper(nums, i + 1, list, cache);
            cache.remove(cache.size() - 1);
        }
    }

    private static int subsetXORSumAnswer1(int[] nums) {
        int sumTotal = 0;
        for (int num : nums) {
            sumTotal |= num;
        }
        return sumTotal << (nums.length - 1);
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 3},
                {5, 1, 6},
                {3, 4, 5, 6, 7, 8},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = subsetXORSumMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("subsetXORSum My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = subsetXORSumAnswer1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("subsetXORSum Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
