package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD09_ValidPerfectSquare.isPerfectSquare;

/**
 * Created by Liu on 2020/5/9.
 */
public class TD09_ValidPerfectSquare_Test {
    public static void main(String[] args) {
        int[] nums = new int[]{16, 14};
        boolean result;
        long startTime;
        long endTime;

        for (int num : nums) {
            startTime = System.currentTimeMillis();
            result = testMy1(num);
            endTime = System.currentTimeMillis();
            System.out.println("TD09_ValidPerfectSquare My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static boolean testMy1(int num) {
        return isPerfectSquare(num);
    }

}
