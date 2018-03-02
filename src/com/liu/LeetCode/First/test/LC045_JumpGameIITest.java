package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC045_JumpGameII.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC045_JumpGameIITest {

    public static void main(String[] args) {
//        int[] nums = new int[]{1};
//        int[] nums = new int[]{1, 2, 3};
//        int[] nums = new int[]{4, 2, 3};
//        int[] nums = new int[]{2, 3, 1, 1, 4};
        int[] nums = new int[]{2, 1, 3, 1, 4};
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("JumpGameII My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("JumpGameII My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("JumpGameII Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return getJumpGameIIMy1(nums);
    }

    private static int testMy2(int[] nums) {
        return getJumpGameIIMy2(nums);
    }

    private static int testAnswer1(int[] nums) {
        return getJumpGameIIAnswer1(nums);
    }
}
