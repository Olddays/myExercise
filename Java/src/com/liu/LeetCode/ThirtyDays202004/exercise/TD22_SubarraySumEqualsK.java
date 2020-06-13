package com.liu.LeetCode.ThirtyDays202004.exercise;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Liu on 2020/4/22.
 */
public class TD22_SubarraySumEqualsK {
    // Memory Limit
    public static int subarraySumMy1(int[] nums, int k) {
        int length = nums.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        int[][] cache = new int[length][length];
        for (int i = 0; i < length; i++) {
            cache[i][i] = nums[i];
            if (cache[i][i] == k) {
                result++;
            }
            for (int j = i + 1; j < length; j++) {
                cache[i][j] = cache[i][j - 1] + nums[j];
                if (cache[i][j] == k) {
                    result++;
                }
            }
        }
        return result;
    }

    public static int subarraySumAnswer1(int[] nums, int k) {
        int length = nums.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        Map<Integer, Integer> sumCache = new HashMap<>();
        // key: sum值, value: 和为sum的子集合数量
        sumCache.put(0, 1);
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (sumCache.containsKey(sum - k)) {
                result += sumCache.get(sum - k);
            }
            sumCache.put(sum, sumCache.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
