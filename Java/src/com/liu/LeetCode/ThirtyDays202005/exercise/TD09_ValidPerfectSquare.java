package com.liu.LeetCode.ThirtyDays202005.exercise;

/**
 * Created by Liu on 2020/5/9.
 */
public class TD09_ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        int i = 2;
        while (i <= num / i) {
            if (num == i * i) {
                return true;
            }
            i++;
        }
        return false;
    }
}
