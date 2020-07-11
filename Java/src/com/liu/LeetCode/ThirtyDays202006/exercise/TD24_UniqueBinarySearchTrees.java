package com.liu.LeetCode.ThirtyDays202006.exercise;

/**
 * Created by Liu on 2020/6/27.
 */
public class TD24_UniqueBinarySearchTrees {
    public static int numTrees(int n) {
        int[] np = new int[n + 1];
        np[0] = np[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                np[i] += np[j - 1] * np[i - j];
            }
        }
        return np[n];
    }
}
