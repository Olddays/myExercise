package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC713_SubarrayProductLessThanK {
    /**
     * Your are given an array of positive integers nums.
     * <p>
     * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [10, 5, 2, 6], k = 100
     * Output: 8
     * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
     * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
     * <p>
     * Note:
     * 0 < nums.length <= 50000.
     * 0 < nums[i] < 1000.
     * 0 <= k < 10^6.
     */

    public static int getSubarrayProductLessThanKMy1(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        List<List<Integer>> subArrayList = new ArrayList<>();
        getSubArrayProductLessList(subArrayList, new ArrayList<>(), 0, 1, nums, k);
        return subArrayList.size();
    }

    private static void getSubArrayProductLessList(List<List<Integer>> subArrayList, ArrayList<Integer> cache,
                                                   int start, int pow, int[] nums, int k) {
        if (pow < k && cache.size() > 0) {
            subArrayList.add(new ArrayList<>(cache));
        }
        for (int i = start; i < nums.length; i++) {
            cache.add(nums[i]);
            getSubArrayProductLessList(subArrayList, cache, i + 1, pow * nums[i], nums, k);
            cache.clear();
        }
    }

    // Time Limit Exceeded 时间复杂度太高啦 哈哈哈 O(n²)
    public static int getSubarrayProductLessThanKMy2(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        List<List<Integer>> subArrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int cachePow = 1;
            List<Integer> cacheList = new ArrayList<>();
            for (int j = i; j < length; j++) {
                cachePow *= nums[j];
                if (cachePow < k) {
                    cacheList.add(nums[j]);
                    subArrayList.add(new ArrayList<>(cacheList));
                } else {
                    break;
                }
            }
        }
        return subArrayList.size();
    }

    public static int getSubarrayProductLessThanKAnswer1(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        long cache = 1;
        int i = 0;
        int j = 0;
        int total = 0;
        while (j < length) {
            cache *= nums[j];
            while (i <= j && cache >= k) {
                cache /= nums[i];
                i++;
            }
            total += (j - i + 1);
            j++;
        }
        return total;
    }

    // Here are two solutions with similar ideas.
    // For nums[i], count range [left, i], whose product is just < k
    public static int getSubarrayProductLessThanKAnswer2(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (k <= 1) return 0;
        int prod = 1;
        int ans = 0;
        int left = 0;
        for (int i = 0; i < length; i++) {
            prod *= nums[i];
            while (prod >= k) {
                prod /= nums[left++];
            }
            ans += i - left + 1;
        }
        return ans;
    }
}
