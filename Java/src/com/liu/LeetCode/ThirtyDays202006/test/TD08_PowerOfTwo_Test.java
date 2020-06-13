package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD08_PowerOfTwo.isPowerOfTwo;

/**
 * Created by Liu on 2020/6/8.
 */
public class TD08_PowerOfTwo_Test {
    public static void main(String[] args) {
        int[] nums;
        boolean result;
        long startTime;
        long endTime;

        nums = new int[]{
                -2147483648,
                1,
                16,
                32,
                218
        };
        for (int n : nums) {
            startTime = System.currentTimeMillis();
            result = testMy1(n);
            endTime = System.currentTimeMillis();
            System.out.println("TD08_PowerOfTwo My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static boolean testMy1(int n) {
        return isPowerOfTwo(n);
    }

}
