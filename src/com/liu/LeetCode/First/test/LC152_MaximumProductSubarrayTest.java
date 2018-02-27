package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC152_MaximumProductSubarray.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC152_MaximumProductSubarrayTest {

    public static void main(String[] args) {
        int[] input = new int[]{
//                2, 3, -2, 4
//                -1, -2
//                0, 2
//                -2, 3, -4
                3, -1, 4
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumProductSubarray My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(input);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumProductSubarray My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy3(input);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumProductSubarray My 3 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy4(input);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumProductSubarray My 4 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy5(input);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumProductSubarray My 5 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(input);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumProductSubarray Answer 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer2(input);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumProductSubarray Answer 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer3(input);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumProductSubarray Answer 3 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] input) {
        return getMaximumProductSubarrayMy1(input);
    }

    private static int testMy2(int[] input) {
        return getMaximumProductSubarrayMy2(input);
    }

    private static int testMy3(int[] input) {
        return getMaximumProductSubarrayMy3(input);
    }

    private static int testMy4(int[] input) {
        return getMaximumProductSubarrayMy4(input);
    }

    private static int testMy5(int[] input) {
        return getMaximumProductSubarrayMy5(input);
    }

    private static int testAnswer1(int[] input) {
        return getMaximumProductSubarrayAnswer1(input);
    }

    private static int testAnswer2(int[] input) {
        return getMaximumProductSubarrayAnswer2(input);
    }

    private static int testAnswer3(int[] input) {
        return getMaximumProductSubarrayAnswer3(input);
    }
}
