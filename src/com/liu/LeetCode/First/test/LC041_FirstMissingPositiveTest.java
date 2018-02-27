package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC041_FirstMissingPositive.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC041_FirstMissingPositiveTest {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, -1, 1};
//        nums = new int[]{1000,-1};
//        nums = new int[]{1000,1};
//        nums = new int[]{};
//        nums = new int[]{2};
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("FirstMissingPositive My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("FirstMissingPositive My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy3(nums);
        endTime = System.currentTimeMillis();
        System.out.println("FirstMissingPositive My 3 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy4(nums);
        endTime = System.currentTimeMillis();
        System.out.println("FirstMissingPositive My 4 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return getFirstMissingPositiveMy1(nums);
    }

    private static int testMy2(int[] nums) {
        return getFirstMissingPositiveMy2(nums);
    }
    private static int testMy3(int[] nums) {
        return getFirstMissingPositiveMy3(nums);
    }

    private static int testMy4(int[] nums) {
        return getFirstMissingPositiveMy4(nums);
    }
}
