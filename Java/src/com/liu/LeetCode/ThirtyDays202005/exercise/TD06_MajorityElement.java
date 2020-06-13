package com.liu.LeetCode.ThirtyDays202005.exercise;

import java.util.HashMap;

/**
 * Created by Liu on 2020/5/6.
 */
public class TD06_MajorityElement {
    public static int majorityElement(int[] nums) {
        int length = nums.length;
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int num : nums) {
            int count = 1;
            if (cache.containsKey(num)) {
                count += cache.get(num);
            }
            if (count > length / 2) {
                return num;
            }
            cache.put(num, count);
        }
        return -1;
    }
}
