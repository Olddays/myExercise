package com.liu.LeetCode.ThirtyDays202007.exercise;

/**
 * Created by Liu on 2020/7/6.
 */
public class TD06_PlusOne {
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int upper = 1;
        for (int i = length - 1; i >= 0; i--) {
            int cache = digits[i] + upper;
            digits[i] = cache % 10;
            upper = cache / 10;
        }
        if (upper == 0) {
            return digits;
        } else {
            int[] result = new int[length + 1];
            result[0] = upper;
            System.arraycopy(digits, 0, result, 1, length);
            return result;
        }
    }
}
