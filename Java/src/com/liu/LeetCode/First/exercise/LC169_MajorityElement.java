package com.liu.LeetCode.First.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 2017/9/30.
 */
public class LC169_MajorityElement {
    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     * <p>
     * You may assume that the array is non-empty and the majority element always exist in the array.
     * <p>
     * Credits:
     * Special thanks to @ts for adding this problem and creating all test cases.
     */

    public static int getMajorityElementMy1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int size = map.get(num) + 1;
                map.put(num, size);
            } else {
                map.put(num, 1);
            }
        }
        int cache = 0;
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > cache) {
                cache = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
