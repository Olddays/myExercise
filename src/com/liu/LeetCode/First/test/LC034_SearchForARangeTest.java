package com.liu.LeetCode.First.test;


import static com.liu.LeetCode.First.exercise.LC034_SearchForARange.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC034_SearchForARangeTest {

    public static void main(String[] args) {
//        int[] nums = new int[]{5, 7, 7, 8, 8, 8, 10};
        int[] nums = new int[]{8};
//        int[] nums = new int[]{7, 8, 9};
        int target = 8;
        int[] result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        for (int i = 0; i < result.length; i++) {
            System.out.println("SearchForARange My 1 result i " + i + " result[i] " + result[i] + " during time " + (endTime - startTime));
        }

        startTime = System.currentTimeMillis();
        result = testMy2(nums, target);
        endTime = System.currentTimeMillis();
        for (int i = 0; i < result.length; i++) {
            System.out.println("SearchForARange My 2 result i " + i + " result[i] " + result[i] + " during time " + (endTime - startTime));
        }

        startTime = System.currentTimeMillis();
        result = testMy3(nums, target);
        endTime = System.currentTimeMillis();
        for (int i = 0; i < result.length; i++) {
            System.out.println("SearchForARange My 3 result i " + i + " result[i] " + result[i] + " during time " + (endTime - startTime));
        }

        startTime = System.currentTimeMillis();
        result = testMy4(nums, target);
        endTime = System.currentTimeMillis();
        for (int i = 0; i < result.length; i++) {
            System.out.println("SearchForARange My 4 result i " + i + " result[i] " + result[i] + " during time " + (endTime - startTime));
        }
    }

    private static int[] testMy1(int[] nums, int target) {
        return getSearchForARangeMy1(nums, target);
    }

    private static int[] testMy2(int[] nums, int target) {
        return getSearchForARangeMy2(nums, target);
    }

    private static int[] testMy3(int[] nums, int target) {
        return getSearchForARangeMy3(nums, target);
    }

    private static int[] testMy4(int[] nums, int target) {
        return getSearchForARangeMy4(nums, target);
    }
}
