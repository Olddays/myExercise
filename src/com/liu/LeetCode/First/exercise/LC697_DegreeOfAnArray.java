package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC697_DegreeOfAnArray {
    /**
     * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
     * <p>
     * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
     * <p>
     * Example 1:
     * <p>
     * Input: [1, 2, 2, 3, 1]
     * Output: 2
     * Explanation:
     * The input array has a degree of 2 because both elements 1 and 2 appear twice.
     * Of the subarrays that have the same degree:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * The shortest length is 2. So return 2.
     * <p>
     * Example 2:
     * <p>
     * Input: [1,2,2,3,1,4,2]
     * Output: 6
     * <p>
     * Note:
     * nums.length will be between 1 and 50,000.
     * nums[i] will be an integer between 0 and 49,999.
     */

    // 无法处理多个degree一样的情况,比如[1,2,2,3,1]
    public static int getDegreeOfAnArrayMy1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Map<Integer, Integer> degreeMap = new HashMap<>();
        for (int num : nums) {
            degreeMap.put(num, degreeMap.getOrDefault(num, 0) + 1);
        }
        int degreeKey = 0;
        int degree = 0;
        for (Map.Entry<Integer, Integer> de : degreeMap.entrySet()) {
            if (de.getValue() > degree) {
                degree = de.getValue();
                degreeKey = de.getKey();
            }
        }
        List<Integer> localList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] == degreeKey) {
                localList.add(i);
            }
        }
        return localList.get(localList.size() - 1) - localList.get(0) + 1;
    }

    public static int getDegreeOfAnArrayMy2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> degreeMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            List<Integer> cache;
            if (degreeMap.containsKey(num)) {
                cache = degreeMap.get(num);
            } else {
                cache = new ArrayList<>();
            }
            cache.add(i);
            degreeMap.put(num, cache);
        }
        int degree = 0;
        int result = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : degreeMap.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() > degree) {
                degree = list.size();
                result = list.get(list.size() - 1) - list.get(0) + 1;
            } else if (list.size() == degree) {
                result = Math.min(list.get(list.size() - 1) - list.get(0) + 1, result);
            }
        }
        return result;
    }
}
