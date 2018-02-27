package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC560_SubarraySumEqualsK {
    /**
     * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
     * <p>
     * Example 1:
     * <p>
     * Input:nums = [1,1,1], k = 2
     * Output: 2
     * <p>
     * Note:
     * <p>
     * The length of the array is in range [1, 20,000].
     * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
     */

    // 这个方式有问题,与题意不符,题意要求是连续
    public static int getSubarraySumEqualsKMy1(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        getSubarraySumMy1(resultList, new ArrayList<>(), nums, 0, k);
        return resultList.size();
    }

    private static void getSubarraySumMy1(ArrayList<ArrayList<Integer>> resultList, ArrayList<Integer> cache, int[] nums, int start, int k) {
        if (k == 0) {
            resultList.add(new ArrayList<>(cache));
            return;
        } else if (k < 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            cache.add(nums[i]);
            getSubarraySumMy1(resultList, cache, nums, i + 1, k - nums[i]);
            cache.remove(cache.size() - 1);
        }
    }

    // 这个方式有问题,虽然是连续,但是由于程序栈的深度,会重复添加
    public static int getSubarraySumEqualsKMy2(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        getSubarraySumMy2(resultList, new ArrayList<>(), nums, 0, k);
        return resultList.size();
    }

    private static void getSubarraySumMy2(ArrayList<ArrayList<Integer>> resultList, ArrayList<Integer> cache, int[] nums, int start, int k) {
        if (k == 0) {
            resultList.add(new ArrayList<>(cache));
            return;
        } else if (k < 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            cache.add(nums[i]);
            getSubarraySumMy2(resultList, cache, nums, i + 1, k - nums[i]);
            cache = new ArrayList<>();
        }
    }

    // 没有考虑到[28, 54, 7, -70, 22, 65, -6],这种包含了负数,导致一开始会超过目标值但最后会回到目标的情况
    public static int getSubarraySumEqualsKMy3(int[] nums, int k) {
        int length = nums.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        for (int i = 0; i < length; i++) {
            int cache = k - nums[i];
            for (int j = i + 1; j < length; j++) {
                if (cache <= 0) {
                    break;
                }
                cache -= nums[j];
            }
            if (cache == 0) {
                result++;
            }
        }
        return result;
    }

    // Solution 1. Brute force. We just need two loops (i, j) and test if SUM[i, j] = k.
    //  Time complexity O(n^2), Space complexity O(1). I bet this solution will TLE.
    //
    // Solution 2. From solution 1, we know the key to solve this problem is SUM[i, j].
    //  So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j].
    //  To achieve this, we just need to go through the array, calculate the current sum and save number of all seen PreSum to a HashMap.
    //  Time complexity O(n), Space complexity O(n).
    //
    // 可以理解为,遍历所有可能的子集合,寻找子集合中所有子元素和等于k的集合数量
    // 重点在于从暴力解法降低时间复杂度
    public static int getSubarraySumEqualsKAnswer1(int[] nums, int k) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> sumCache = new HashMap<>();
        // key: sum值, value: 和为sum的子集合数量
        sumCache.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumCache.containsKey(sum - k)) {
                result += sumCache.get(sum - k);
            }
            sumCache.put(sum, sumCache.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
