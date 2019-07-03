package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC560_SubarraySumEqualsK.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC560_SubarraySumEqualsKTest {

    public static void main(String[] args) {
        int[] nums = {
                1, 1, 1
//                28, 54, 7, -70, 22, 65, -6
        };
        int input = 2;
//        int input = 100;
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, input);
        endTime = System.currentTimeMillis();
        System.out.println("SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums, input);
        endTime = System.currentTimeMillis();
        System.out.println("SubarraySumEqualsK My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy3(nums, input);
        endTime = System.currentTimeMillis();
        System.out.println("SubarraySumEqualsK My 3 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums, input);
        endTime = System.currentTimeMillis();
        System.out.println("SubarraySumEqualsK Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums, int k) {
        return getSubarraySumEqualsKMy1(nums, k);
    }

    private static int testMy2(int[] nums, int k) {
        return getSubarraySumEqualsKMy2(nums, k);
    }

    private static int testMy3(int[] nums, int k) {
        return getSubarraySumEqualsKMy3(nums, k);
    }

    private static int testAnswer1(int[] nums, int k) {
        return getSubarraySumEqualsKAnswer1(nums, k);
    }
}
