package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC084_LargestRectangleInHistogram.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC084_LargestRectangleInHistogramTest {

    public static void main(String[] args) {
        int[] nums = new int[]{
                2, 1, 5, 6, 2, 3,
//                1, 1, 1, 1, 1, 1,
        };
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("LargestRectangleInHistogram My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("LargestRectangleInHistogram My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy3(nums);
        endTime = System.currentTimeMillis();
        System.out.println("LargestRectangleInHistogram My 3 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("LargestRectangleInHistogram Answer 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("LargestRectangleInHistogram Answer 2 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return getLargestRectangleInHistogramMy1(nums);
    }

    private static int testMy2(int[] nums) {
        return getLargestRectangleInHistogramMy2(nums);
    }

    private static int testMy3(int[] nums) {
        return getLargestRectangleInHistogramMy3(nums);
    }

    private static int testAnswer1(int[] nums) {
        return getLargestRectangleInHistogramAnswer1(nums);
    }

    private static int testAnswer2(int[] nums) {
        return getLargestRectangleInHistogramAnswer2(nums);
    }
}
