package com.liu.LeetCode.ThirtyDays202004.test;

import static com.liu.LeetCode.ThirtyDays202004.exercise.TD25_JumpGame.canJumpMy1;
import static com.liu.LeetCode.ThirtyDays202004.exercise.TD25_JumpGame.canJumpMy2;

/**
 * Created by Liu on 2020/4/26.
 */
public class TD25_JumpGame_Test {

    public static void main(String[] args) {
        int[] nums;
        boolean result;
        long startTime;
        long endTime;


        nums = new int[]{0};
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));


        nums = new int[]{2, 3, 1, 1, 4};
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));


        nums = new int[]{3, 2, 1, 0, 4};
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));

    }

    private static boolean testMy1(int[] nums) {
        return canJumpMy1(nums);
    }

    private static boolean testMy2(int[] nums) {
        return canJumpMy2(nums);
    }

}
