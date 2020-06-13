package com.liu.LeetCode.ThirtyDays202006.exercise;

/**
 * Created by Liu on 2020/6/8.
 */
public class TD08_PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        String s = Integer.toBinaryString(n);
        if (s.length() > 1) {
            return !s.substring(1).contains("1");
        }
        return n == 1;
    }
}
