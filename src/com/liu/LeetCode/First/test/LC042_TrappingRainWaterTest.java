package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC042_TrappingRainWater.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC042_TrappingRainWaterTest {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        nums = new int[]{4, 2, 3};
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TrappingRainWater My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TrappingRainWater My 2 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return getTrappingRainWaterMy1(nums);
    }

    private static int testMy2(int[] nums) {
        return getTrappingRainWaterMy2(nums);
    }
}
