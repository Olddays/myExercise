package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD04_UglyNumberII.nthUglyNumber;

/**
 * Created by Liu on 2020/7/6.
 */
public class TD04_UglyNumberII_Test {
    public static void main(String[] args) {
        int n;
        int result;
        long startTime;
        long endTime;


        n = 10;
        startTime = System.currentTimeMillis();
        result = testMy1(n);
        endTime = System.currentTimeMillis();
        System.out.println("TD04_UglyNumberII My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(int n) {
        return nthUglyNumber(n);
    }

}
