package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/14.
 */
public class LC007_ReverseInteger {
    /**
     * Reverse digits of an integer.
     * <p>
     * Example1: x = 123, return 321
     * Example2: x = -123, return -321
     * <p>
     * click to show spoilers.
     * <p>
     * Note:
     * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
     */

    // 题目中提到可能会数据过大
    public static int getReverseIntegerMy1(int x) {
        if (x == 0) {
            return x;
        }
        char[] value = String.valueOf(x).toCharArray();
        boolean isNegative = false;
        if (value[0] == '-') {
            isNegative = true;
        }
        String cache = "";
        for (int i = value.length - 1; i > 0; i--) {
            cache += value[i];
        }
        if (!isNegative) {
            cache += value[0];
        } else {
            cache = "-" + cache;
        }
        int result;
        try {
            result = Integer.valueOf(cache);
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }
}
