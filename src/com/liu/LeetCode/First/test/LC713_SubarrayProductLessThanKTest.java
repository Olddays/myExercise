package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC713_SubarrayProductLessThanK.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC713_SubarrayProductLessThanKTest {

    public static void main(String[] args) {
        int[] nums = {
                10, 5, 2, 6
//                10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3
        };
        int k = 100;
//        int k = 19;
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("SubarrayProductLessThanK My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("SubarrayProductLessThanK My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("SubarrayProductLessThanK Answer 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer2(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("SubarrayProductLessThanK Answer 2 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums, int k) {
        return getSubarrayProductLessThanKMy1(nums, k);
    }

    private static int testMy2(int[] nums, int k) {
        return getSubarrayProductLessThanKMy2(nums, k);
    }

    private static int testAnswer1(int[] nums, int k) {
        return getSubarrayProductLessThanKAnswer1(nums, k);
    }

    private static int testAnswer2(int[] nums, int k) {
        return getSubarrayProductLessThanKAnswer2(nums, k);
    }
}
