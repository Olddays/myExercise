package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC053_MaximumSubarray.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC053_MaximumSubarrayTest {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = new int[]{1};
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumSubarray My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumSubarray Answer 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumSubarray Answer 2 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] matrix) {
        return getMaximumSubarrayMy1(matrix);
    }

    private static int testAnswer1(int[] matrix) {
        return getMaximumSubarrayAnswer1(matrix);
    }

    private static int testAnswer2(int[] matrix) {
        return getMaximumSubarrayAnswer2(matrix);
    }
}
