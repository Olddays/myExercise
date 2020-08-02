package com.liu.LeetCode.ThirtyDays202007.exercise;

/**
 * Created by Liu on 2020/7/16.
 */
public class TD16_PowXN {
    public static double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    public static double powAnswer1(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? powAnswer1(x * x, n / 2) : x * powAnswer1(x * x, n / 2);
    }
}
