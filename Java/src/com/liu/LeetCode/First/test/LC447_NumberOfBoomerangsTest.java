package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC447_NumberOfBoomerangs.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC447_NumberOfBoomerangsTest {

    public static void main(String[] args) {
        int[][][] pointsList = {
//                {{0, 0}, {1, 0}, {2, 0}},
                {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}},
        };
        long startTime;
        int result;
        long endTime;

        for (int[][] points : pointsList) {
            startTime = System.currentTimeMillis();
            result = testMy1(points);
            endTime = System.currentTimeMillis();
            System.out.println("NumberOfBoomerangs My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testAnswer1(points);
            endTime = System.currentTimeMillis();
            System.out.println("NumberOfBoomerangs Answer 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int[][] points) {
        return getNumberOfBoomerangsMy1(points);
    }

    private static int testAnswer1(int[][] points) {
        return getNumberOfBoomerangsAnswer1(points);
    }
}
