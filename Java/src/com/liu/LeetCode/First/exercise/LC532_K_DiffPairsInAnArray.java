package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by liu on 2017/9/30.
 */
public class LC532_K_DiffPairsInAnArray {
    /**
     * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
     * <p>
     * Example 1:
     * <p>
     * Input: [3, 1, 4, 1, 5], k = 2
     * Output: 2
     * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
     * Although we have two 1s in the input, we should only return the number of unique pairs.
     * <p>
     * Example 2:
     * <p>
     * Input:[1, 2, 3, 4, 5], k = 1
     * Output: 4
     * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
     * <p>
     * Example 3:
     * <p>
     * Input: [1, 3, 1, 5, 4], k = 0
     * Output: 1
     * Explanation: There is one 0-diff pair in the array, (1, 1).
     * <p>
     * Note:
     * <p>
     * The pairs (i, j) and (j, i) count as the same pair.
     * The length of the array won't exceed 10,000.
     * All the integers in the given input belong to the range: [-1e7, 1e7].
     */

    // 无法处理当k=0的时候的情况
    public static int getK_DiffPairsInAnArrayMy1(int[] nums, int k) {
        int length = nums.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = length - 1; i >= 0; i--) {
            if (set.contains(nums[i] - k)) {
                set.remove(nums[i]);
                result++;
            }
        }
        return result;
    }

    // 无法处理[1,1,1,1,1],k=0的情况
    public static int getK_DiffPairsInAnArrayMy2(int[] nums, int k) {
        int length = nums.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (k > 0) {
            for (int i = length - 1; i >= 0; i--) {
                if (set.contains(nums[i] - k)) {
                    set.remove(nums[i]);
                    result++;
                }
            }
        } else if (k == 0) {
            result = length - set.size();
        }
        return result;
    }

    public static int getK_DiffPairsInAnArrayMy3(int[] nums, int k) {
        int length = nums.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int size = map.get(num) + 1;
                map.put(num, size);
            } else {
                map.put(num, 1);
            }
        }
        if (k > 0) {
            for (int i = length - 1; i >= 0; i--) {
                if (map.containsKey(nums[i]) && map.containsKey(nums[i] - k)) {
                    map.remove(nums[i]);
                    result++;
                }
            }
        } else if (k == 0) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    result++;
                }
            }
        }
        return result;
    }

    // 这个答案跟我的方案三一致,但是写法上优雅的多
    public static int getK_DiffPairsInAnArrayAnswer1(int[] nums, int k) {
        int result = 0;
        if (nums == null || nums.length == 0 || k < 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    result++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    result++;
                }
            }
        }
        return result;
    }
}
