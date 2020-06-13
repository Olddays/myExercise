package com.liu.LeetCode.ThirtyDays202005.exercise;

/**
 * Created by Liu on 2020/5/6.
 */
public class TD04_NumberComplement {
    public static int findComplementMy1(int num) {
        if (num < 2) {
            return 0;
        }
        int target = 2;
        while (target <= num) {
            target *= 2;
        }
        target--;
        return target - num;
    }

    public static int findComplementAnswer1(int num) {
        int mask = Integer.MAX_VALUE;
        while ((mask & num) != 0) {
            mask <<= 1;
        }
        return ~mask & ~num;
    }
}
