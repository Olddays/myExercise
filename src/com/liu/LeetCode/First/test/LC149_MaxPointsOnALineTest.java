package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC149_MaxPointsOnALine.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC149_MaxPointsOnALineTest {

    public static void main(String[] args) {
        int[][] input = new int[][]{
//                {1, 2}, {2, 4}, {3, 6}
//                {0, 0}, {0, 0}
                {0, 0}, {-1, -1}, {2, 2}
//                {0, 0}, {1, -1}, {1, 1}
//                {0, 0}, {1, 1}, {0, 0}
        };
        Point[] points = new Point[input.length];
        for (int i = 0; i < input.length; i++) {
            points[i] = new Point(input[i][0], input[i][1]);
        }
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(points);
        endTime = System.currentTimeMillis();
        System.out.println("MaxPointsOnALine My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(points);
        endTime = System.currentTimeMillis();
        System.out.println("MaxPointsOnALine My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(points);
        endTime = System.currentTimeMillis();
        System.out.println("MaxPointsOnALine Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(Point[] points) {
        return getMaxPointsOnALineMy1(points);
    }

    private static int testMy2(Point[] points) {
        return getMaxPointsOnALineMy2(points);
    }

    private static int testAnswer1(Point[] points) {
        return getMaxPointsOnALineAnswer1(points);
    }
}
