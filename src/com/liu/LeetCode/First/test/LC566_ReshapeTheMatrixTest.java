package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC566_ReshapeTheMatrix.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC566_ReshapeTheMatrixTest {

    public static void main(String[] args) {
//        int[][] nums = {
//                {1, 4}, {3, 2}
//        };
//        int row = 2;
//        int list = 4;
        int[][] nums = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30}
        };
        int row = 22;
        int list = 15;
        long startTime;
        int[][] result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, row, list);
        endTime = System.currentTimeMillis();
        System.out.println("ReshapeTheMatrix My 1 result.length " + result.length + " during time " + (endTime - startTime));
        for (int[] line : result) {
            for (int i : line) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int[][] testMy1(int[][] nums, int r, int c) {
        return getReshapeTheMatrixMy1(nums, r, c);
    }
}
