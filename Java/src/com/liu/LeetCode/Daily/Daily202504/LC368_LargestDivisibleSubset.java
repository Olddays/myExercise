package com.liu.LeetCode.Daily.Daily202504;

import java.util.*;

public class LC368_LargestDivisibleSubset {

    // 回溯
    // Time Limit Exceeded
    private static List<Integer> largestDivisibleSubsetMyError1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> listSet = new ArrayList<>();
        largestDivisibleSubsetMy1Helper(nums, 0, new ArrayList<>(), listSet);
        List<Integer> result = null;
        int maxSize = 0;
        for (List<Integer> list : listSet) {
            if (list.size() > maxSize) {
                maxSize = list.size();
                result = list;
            }
        }
        return result;
    }

    private static void largestDivisibleSubsetMy1Helper(int[] nums, int index, ArrayList<Integer> cache, List<List<Integer>> listSet) {
        listSet.add(new ArrayList<>(cache));
        for (int i = index; i < nums.length; i++) {
            if (cache.isEmpty() || nums[i] % cache.get(cache.size() - 1) == 0) {
                cache.add(nums[i]);
                largestDivisibleSubsetMy1Helper(nums, i + 1, cache, listSet);
                cache.remove(cache.size() - 1);
            }
        }
    }

    private static List<Integer> largestDivisibleSubsetMyError2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> cache = new ArrayList<>();
            cache.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                // 这个地方只能依次计算，所以无法处理（9，18，54，90，108，180.360.720）这种情况
                // 正确应该是(9,18,90,180,360,720)，这里会算成(9，18，54，180.360.720)
                if (nums[j] % cache.get(cache.size() - 1) == 0) {
                    cache.add(nums[j]);
                }
            }
            if (cache.size() > result.size()) {
                result = cache;
            }
        }
        return result;
    }

    // DP
    // Beats 99.64%
    private static List<Integer> largestDivisibleSubsetMy1(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1); // 至少有一个自己，所以默认都初始化为1
        Arrays.sort(nums);

        int maxSize = 1, maxIndex = 0;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) { // 大数去整除小数，这样可以保证所有的数都能被整除
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > maxSize) {
                        maxSize = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int num = nums[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (num % nums[i] == 0 && dp[i] == maxSize) {
                result.add(nums[i]);
                num = nums[i];
                maxSize--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {5, 9, 18, 54, 108, 540, 90, 180, 360, 720},
                {3, 4, 16, 8},
                {1, 2, 3},
                {1, 2, 4, 8},
        };
        List<Integer> result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = largestDivisibleSubsetMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("largestDivisibleSubset My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
