package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD25_UncrossedLines.maxUncrossedLines;

/**
 * Created by Liu on 2020/5/28.
 */
public class TD25_UncrossedLines_Test {
    public static void main(String[] args) {
        int[] A;
        int[] B;
        int result;
        long startTime;
        long endTime;

        A = new int[]{
                2, 5, 1, 2, 5
        };
        B = new int[]{
                10, 5, 2, 1, 5, 2
        };
        startTime = System.currentTimeMillis();
        result = testMy1(A, B);
        endTime = System.currentTimeMillis();
        System.out.println("TD23_IntervalListIntersections My 1 result: " + result + ", during time " + (endTime - startTime));

        A = new int[]{
                1, 3, 7, 1, 7, 5
        };
        B = new int[]{
                1, 9, 2, 5, 1
        };
        startTime = System.currentTimeMillis();
        result = testMy1(A, B);
        endTime = System.currentTimeMillis();
        System.out.println("TD23_IntervalListIntersections My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(int[] A, int[] B) {
        return maxUncrossedLines(A, B);
    }
}