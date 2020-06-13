package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD23_IntervalListIntersections.intervalIntersection;

/**
 * Created by Liu on 2020/5/25.
 */
public class TD23_IntervalListIntersections_Test {
    public static void main(String[] args) {
        int[][] A;
        int[][] B;
        int[][] result;
        long startTime;
        long endTime;

        A = new int[][]{
                {0, 2},
                {5, 10},
                {13, 23},
                {24, 25}
        };
        B = new int[][]{
                {1, 5},
                {8, 12},
                {15, 24},
                {25, 26}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(A, B);
        endTime = System.currentTimeMillis();
        System.out.println("TD23_IntervalListIntersections My 1, during time " + (endTime - startTime));
        for (int[] line : result) {
            for (int i : line) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    private static int[][] testMy1(int[][] A, int[][] B) {
        return intervalIntersection(A, B);
    }
}
