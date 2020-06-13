package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD30_KClosestPointsToOrigin.kClosestMy1;

/**
 * Created by Liu on 2020/6/1.
 */
public class TD30_KClosestPointsToOrigin_Test {
    public static void main(String[] args) {
        int K;
        int[][] points;
        int[][] result;
        long startTime;
        long endTime;

        points = new int[][]{
                {1, 3},
                {-2, 2}
        };
        K = 1;
        startTime = System.currentTimeMillis();
        result = testMy1(points, K);
        endTime = System.currentTimeMillis();
        System.out.println("TD30_KClosestPointsToOrigin My 1 result.size: " + result.length + ", during time " + (endTime - startTime));
        for (int[] point : result) {
            System.out.println(point[0] + " " + point[1]);
        }
        System.out.println();


        points = new int[][]{
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        K = 2;
        startTime = System.currentTimeMillis();
        result = testMy1(points, K);
        endTime = System.currentTimeMillis();
        System.out.println("TD30_KClosestPointsToOrigin My 1 result.size: " + result.length + ", during time " + (endTime - startTime));
        for (int[] point : result) {
            System.out.println(point[0] + " " + point[1]);
        }
        System.out.println();
    }

    private static int[][] testMy1(int[][] points, int K) {
        return kClosestMy1(points, K);
    }
}
