package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC048_RotateImage.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC048_RotateImageTest {

    public static void main(String[] args) {
//        int[][] nums = new int[][]{{1}, {2}};
        int[][] nums = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
//        int[][] nums = new int[][]{
//                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("RotateImage My 1 during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("RotateImage My 2 during time " + (endTime - startTime));
    }

    private static void testMy1(int[][] matrix) {
        getRotateImageMy1(matrix);
    }

    private static void testMy2(int[][] matrix) {
        getRotateImageMy2(matrix);
    }
}
