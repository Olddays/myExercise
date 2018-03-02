package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC665_NonDecreasingArray.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC665_NonDecreasingArrayTest {

    public static void main(String[] args) {
        int[] nums = {
//                3, 4, 2, 3
//                4, 2, 1
//                -1, 4, 2, 3
                2, 3, 3, 2, 4
        };
        long startTime;
        boolean result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("NonDecreasingArray My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("NonDecreasingArray My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy3(nums);
        endTime = System.currentTimeMillis();
        System.out.println("NonDecreasingArray My 3 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("NonDecreasingArray Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testMy1(int[] nums) {
        return getNonDecreasingArrayMy1(nums);
    }

    private static boolean testMy2(int[] nums) {
        return getNonDecreasingArrayMy2(nums);
    }

    private static boolean testMy3(int[] nums) {
        return getNonDecreasingArrayMy3(nums);
    }

    private static boolean testAnswer1(int[] nums) {
        return getNonDecreasingArrayAnswer1(nums);
    }
}
