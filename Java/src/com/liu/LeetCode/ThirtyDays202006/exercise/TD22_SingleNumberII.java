package com.liu.LeetCode.ThirtyDays202006.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Liu on 2020/6/22.
 */
public class TD22_SingleNumberII {
    // 首先存储空间是n,其次,在出现-Integer.Max_Int的时候会出错
    public static int singleNumberMy1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int result = nums[0];
        for (int num : nums) {
            if (!set.contains(num)) {
                result = num;
                set.add(num);
            }
        }
        return result;
    }

    public static int singleNumberAnswer1(int[] nums) {
        int x1 = 0;
        int x2 = 0;
        for (int num : nums) {
            x2 ^= x1 & num;
            x1 ^= num;
            int cache = ~(x1 & x2);
            x2 &= cache;
            x1 &= cache;
        }
        return x1;
    }
}
