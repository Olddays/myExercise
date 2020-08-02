package com.liu.LeetCode.ThirtyDays202007.exercise;

/**
 * Created by Liu on 2020/7/1.
 */
public class TD01_ArrangingCoins {
    // Time Limited
    public static int arrangeCoinsMy1(int n) {
        int sum = 0;
        int i = 0;
        while (sum <= n) {
            i++;
            sum += i;
        }
        return i - 1;
    }

    public static int arrangeCoinsMy2(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }
}
