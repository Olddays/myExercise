package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC136_SingleNumber {
    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     * <p>
     * Note:
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     */

    public static int getSingleNumberMy1(int[] nums) {
        Set<Integer> setCache = new HashSet<>();
        for (int num : nums) {
            if (!setCache.contains(num)) {
                setCache.add(num);
            } else {
                setCache.remove(num);
            }
        }
        return setCache.iterator().next();
    }
}
