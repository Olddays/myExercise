package com.liu.LeetCode.ThirtyDays202006.exercise;

/**
 * Created by Liu on 2020/6/4.
 */
public class TD04_ReverseString {
    public static void reverseString(char[] s) {
        int length = s.length;
        if (length <= 1) {
            return;
        }
        for (int i = 0; i < length / 2; i++) {
            char cache = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = cache;
        }
    }
}
