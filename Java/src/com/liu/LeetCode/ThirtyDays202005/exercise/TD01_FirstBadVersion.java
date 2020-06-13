package com.liu.LeetCode.ThirtyDays202005.exercise;

/**
 * Created by Liu on 2020/5/6.
 */
public abstract class TD01_FirstBadVersion {
    private static boolean isBadVersion(int version) {
        return version >= 1702766719;
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        if (n < left) {
            return 0;
        }
        while (left < right) {
            int cache = left + (right - left) / 2;
            if (isBadVersion(cache)) {
                right = cache;
            } else {
                left = cache + 1;
            }
        }
        return left;
    }
}
