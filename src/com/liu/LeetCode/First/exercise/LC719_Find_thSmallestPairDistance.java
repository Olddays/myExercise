package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC719_Find_thSmallestPairDistance {
    /**
     * Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * nums = [1,3,1]
     * k = 1
     * Output: 0
     * Explanation:
     * Here are all the pairs:
     * (1,3) -> 2
     * (1,1) -> 0
     * (3,1) -> 2
     * Then the 1st smallest distance pair is (1,1), and its distance is 0.
     * <p>
     * Note:
     * <p>
     * 2 <= len(nums) <= 10000.
     * 0 <= nums[i] < 1000000.
     * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
     */

    // 好吧~: Time Limit Exceeded,好吧~时间复杂度太高了
    public static int getFind_thSmallestPairDistanceMy1(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        List<Integer> distanceCache = new ArrayList<>();
        getSubArrayPairMy1(distanceCache, new ArrayList<>(), 0, nums);
        length = distanceCache.size();
        int[] cache = new int[length];
        for (int i = 0; i < length; i++) {
            cache[i] = distanceCache.get(i);
        }
        Arrays.sort(cache);
        return cache[k - 1];
    }

    private static void getSubArrayPairMy1(List<Integer> distanceCache, ArrayList<Integer> cache, int start, int[] nums) {
        if (cache.size() == 2) {
            distanceCache.add(cache.get(1) - cache.get(0));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            cache.add(nums[i]);
            getSubArrayPairMy1(distanceCache, cache, i + 1, nums);
            cache.remove(cache.size() - 1);
        }
    }

    public static int getFind_thSmallestPairDistanceAnswer1(int nums[], int k) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        // Minimum absolute difference
        int low = nums[1] - nums[0];
        for (int i = 1; i < length - 1; i++) {
            low = Math.min(low, nums[i + 1] - nums[i]);
        }

        // Maximum absolute difference
        int high = nums[length - 1] - nums[0];

        // Do binary search for k-th absolute difference
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairsAnswer1(nums, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Returns number of pairs with absolute difference less than or equal to mid.
    private static int countPairsAnswer1(int[] a, int mid) {
        int n = a.length, res = 0;
        for (int i = 0; i < n; ++i) {
            int j = i;
            while (j < n && a[j] - a[i] <= mid) j++;
            res += j - i - 1;
        }
        return res;
    }

    public static int getFind_thSmallestPairDistanceAnswer2(int nums[], int k) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        // Minimum absolute difference
        int low = nums[1] - nums[0];
        for (int i = 1; i < length - 1; i++) {
            low = Math.min(low, nums[i + 1] - nums[i]);
        }

        // Maximum absolute difference
        int high = nums[length - 1] - nums[0];

        // Do binary search for k-th absolute difference
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairsAnswer2(nums, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Returns index of first index of element which is greater than key
    private static int upperBound(int[] a, int low, int high, int key) {
        if (a[high] <= key) return high + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (key >= a[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Returns number of pairs with absolute difference less than or equal to mid.
    private static int countPairsAnswer2(int[] a, int mid) {
        int n = a.length, res = 0;
        for (int i = 0; i < n; i++) {
            res += upperBound(a, i, n - 1, a[i] + mid) - i - 1;
        }
        return res;
    }
}
