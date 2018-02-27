package com.liu.LeetCode.First.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC152_MaximumProductSubarray {
    /**
     * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
     * <p>
     * For example, given the array [2,3,-2,4],
     * the contiguous subarray [2,3] has the largest product = 6.
     */

    // 未考虑[-1]以及[-1,-2]这种输入
    public static int getMaximumProductSubarrayMy1(int[] nums) {
        int result = 0;
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        int cache = 1;
        for (int num : nums) {
            if (num > 0) {
                cache *= num;
            } else {
                result = Math.max(cache, result);
                cache = 0;
            }
        }
        return result;
    }

    // 没有考虑输入[0,2]
    public static int getMaximumProductSubarrayMy2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int result = nums[0];
        int productCache = nums[0];
        for (int i = 1; i < length; i++) {
            int cache = productCache * nums[i];
            if (cache > 0) {
                productCache = cache;
            } else {
                productCache = 0;
            }
            result = Math.max(cache, result);
        }
        return result;
    }

    // 未考虑[-2, 3, -4]
    public static int getMaximumProductSubarrayMy3(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int result = nums[0];
        int productCache = nums[0];
        for (int i = 1; i < length; i++) {
            int cache = productCache * nums[i];
            if (cache > 0) {
                productCache = cache;
            } else {
                productCache = nums[i];
            }
            result = Math.max(productCache, result);
        }
        return result;
    }

    // 没有考虑[3,-1,4]的情况
    public static int getMaximumProductSubarrayMy4(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int productCache = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], nums[0]);
        for (int i = 1; i < length; i++) {
            int cache = productCache * nums[i];
            if (cache != 0) {
                productCache = cache;
            } else {
                productCache = nums[i];
            }
            map.put(nums[i], productCache);
        }
        int result = nums[0];
        result = Math.max(productCache, result);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result = Math.max(result, entry.getValue());
        }
        return result;
    }

    public static int getMaximumProductSubarrayMy5(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            int maxCache = Math.max(max * nums[i], min * nums[i]);
            int minCache = Math.min(temp * nums[i], min * nums[i]);
            max = Math.max(maxCache, nums[i]);
            min = Math.min(minCache, nums[i]);
            result = Math.max(max, result);
        }
        return result;
    }

    // There's no need to use O(n) space, as all that you need is a minhere and maxhere. (local max and local min), then you can get maxsofar (which is global max) from them.
    // There's a chapter in Programming Pearls 2 that discussed the MaxSubnumsrray problem, the idea is similar.
    public static int getMaximumProductSubarrayAnswer1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int maxHerePre = nums[0];
        int minHerePre = nums[0];
        int maxSoFar = nums[0];
        int maxHere, minHere;
        for (int i = 1; i < length; i++) {
            maxHere = Math.max(Math.max(maxHerePre * nums[i], minHerePre * nums[i]), nums[i]);
            minHere = Math.min(Math.min(maxHerePre * nums[i], minHerePre * nums[i]), nums[i]);
            maxSoFar = Math.max(maxHere, maxSoFar);
            maxHerePre = maxHere;
            minHerePre = minHere;
        }
        return maxSoFar;
    }

    // Loop through the array, each time remember the max and min value for the previous product,
    // the most important thing is to update the max and min value:
    // we have to compare among max * nums[i], min * nums[i] as well as nums[i],
    // since this is product, a negative * negative could be positive.
    public static int getMaximumProductSubarrayAnswer2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

    // f[i] means maximum product that can be achieved ending with i
    // g[i] means minimum product that can be achieved ending with i
    public static int getMaximumProductSubarrayAnswer3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] f = new int[nums.length];
        int[] g = new int[nums.length];
        f[0] = nums[0];
        g[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(Math.max(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
            g[i] = Math.min(Math.min(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
