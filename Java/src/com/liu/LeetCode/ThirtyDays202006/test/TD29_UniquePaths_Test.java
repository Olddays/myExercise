package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD29_UniquePaths.uniquePaths;

/**
 * Created by Liu on 2020/6/29.
 */
public class TD29_UniquePaths_Test {
    public static void main(String[] args) {
        int m;
        int n;
        int result;
        long startTime;
        long endTime;

        m = 3;
        n = 2;
        startTime = System.currentTimeMillis();
        result = testMy1(m, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD25_FindTheDuplicateNumber My 1 result " + result + " during time " + (endTime - startTime));

        m = 7;
        n = 3;
        startTime = System.currentTimeMillis();
        result = testMy1(m, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD25_FindTheDuplicateNumber My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int m, int n) {
        return uniquePaths(m, n);
    }

}
