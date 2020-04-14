package com.liu.LeetCode.ThirtyDays202004.exercise;

public class TD02_HappyNum {
    public static boolean isHappy(int n) {
        if (n == 0) {
            return false;
        }
        int count = getIntListCount(n);
        while (count > 4) {
            count = getIntListCount(count);
        }
        return count == 1;
    }

    private static int getIntListCount(int n) {
        int cache = n;
        int result = 0;
        while (cache > 0) {
            result += Math.pow(cache % 10, 2);
            cache = cache / 10;
        }
        return result;
    }
}
