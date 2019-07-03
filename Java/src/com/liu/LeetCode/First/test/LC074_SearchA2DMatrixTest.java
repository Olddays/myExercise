package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC074_SearchA2DMatrix.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC074_SearchA2DMatrixTest {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50},

//                {1},
                {1, 3}
        };
        int target = 3;
//        int target = 1;
        boolean result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("SearchA2DMatrix My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("SearchA2DMatrix My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy3(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("SearchA2DMatrix My 3 result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testMy1(int[][] nums, int target) {
        return getSearchA2DMatrixMy1(nums, target);
    }

    private static boolean testMy2(int[][] nums, int target) {
        return getSearchA2DMatrixMy2(nums, target);
    }

    private static boolean testMy3(int[][] nums, int target) {
        return getSearchA2DMatrixMy3(nums, target);
    }
}
