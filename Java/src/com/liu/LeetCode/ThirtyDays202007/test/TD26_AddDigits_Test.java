package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD26_AddDigits.addDigits;

/**
 * Created by Liu on 2020/7/27.
 */
public class TD26_AddDigits_Test {
    public static void main(String[] args) {
        int num;
        int result;
        long startTime;
        long endTime;


        num = 38;
        startTime = System.currentTimeMillis();
        result = testMy1(num);
        endTime = System.currentTimeMillis();
        System.out.println("TD26_AddDigits My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(int num) {
        return addDigits(num);
    }
}
