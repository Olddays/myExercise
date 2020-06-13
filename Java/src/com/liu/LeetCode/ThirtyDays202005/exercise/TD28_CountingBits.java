package com.liu.LeetCode.ThirtyDays202005.exercise;

/**
 * Created by Liu on 2020/5/28.
 */
public class TD28_CountingBits {
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        if (num < 1) {
            return result;
        }
        result[0] = 0;
        result[1] = 1;
        int count = 2;
        for (int i = 2; i < num + 1; i++) {
            if (i == count * 2) {
                result[i] = 1;
                count = i;
            } else {
                result[i] = result[i - count] + 1;
            }
        }
        return result;
    }
}
