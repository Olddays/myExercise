package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC628_MaximumProductOfThreeNumbers.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC628_MaximumProductOfThreeNumbersTest {

    public static void main(String[] args) {
        int[] nums = {
                -4, -3, -2, -1, 60
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumProductOfThreeNumbers My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumProductOfThreeNumbers My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumProductOfThreeNumbers Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return getMaximumProductOfThreeNumbersMy1(nums);
    }

    private static int testMy2(int[] nums) {
        return getMaximumProductOfThreeNumbersMy2(nums);
    }

    private static int testAnswer1(int[] nums) {
        return getMaximumProductOfThreeNumbersAnswer1(nums);
    }
}
