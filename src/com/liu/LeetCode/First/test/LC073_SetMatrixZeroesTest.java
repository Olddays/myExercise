package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC073_SetMatrixZeroes.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC073_SetMatrixZeroesTest {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
//                {1, 0, 1},
//                {1, 0, 1},
//                {1, 1, 1},
                {0, 1},
        };
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("SetMatrixZeroes My 1 during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("SetMatrixZeroes My 2 during time " + (endTime - startTime));
    }

    private static void testMy1(int[][] nums) {
        getSetMatrixZeroesMy1(nums);
    }

    private static void testMy2(int[][] nums) {
        getSetMatrixZeroesMy2(nums);
    }
}
