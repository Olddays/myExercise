package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC055_JumpGame.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC055_JumpGameTest {

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 1, 0, 4, 4};
//        int[] nums = new int[]{2, 3, 1, 1, 4};
//        int[] nums = new int[]{0};
//        int[] nums = new int[]{0, 1};
//        int[] nums = new int[]{2, 0};
        int[] nums = new int[]{2, 0, 0};
        boolean result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("JumpGame My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("JumpGame My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy3(nums);
        endTime = System.currentTimeMillis();
        System.out.println("JumpGame My 3 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy4(nums);
        endTime = System.currentTimeMillis();
        System.out.println("JumpGame My 4 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy5(nums);
        endTime = System.currentTimeMillis();
        System.out.println("JumpGame My 5 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("JumpGame Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testMy1(int[] nums) {
        return getJumpGameMy1(nums);
    }

    private static boolean testMy2(int[] nums) {
        return getJumpGameMy2(nums);
    }

    private static boolean testMy3(int[] nums) {
        return getJumpGameMy3(nums);
    }

    private static boolean testMy4(int[] nums) {
        return getJumpGameMy4(nums);
    }

    private static boolean testMy5(int[] nums) {
        return getJumpGameMy5(nums);
    }

    private static boolean testAnswer1(int[] nums) {
        return getJumpGameAnswer1(nums);
    }
}
