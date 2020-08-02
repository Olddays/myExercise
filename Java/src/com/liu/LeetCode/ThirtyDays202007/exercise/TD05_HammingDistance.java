package com.liu.LeetCode.ThirtyDays202007.exercise;

/**
 * Created by Liu on 2020/7/6.
 */
public class TD05_HammingDistance {
    public static int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            count += z % 2;
            z /= 2;
        }
        return count;
    }
}
