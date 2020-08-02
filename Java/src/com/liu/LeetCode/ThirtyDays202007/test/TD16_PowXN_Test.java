package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD16_PowXN.myPow;
import static com.liu.LeetCode.ThirtyDays202007.exercise.TD16_PowXN.powAnswer1;

/**
 * Created by Liu on 2020/7/16.
 */
public class TD16_PowXN_Test {

    public static void main(String[] args) {
        double x;
        int n;
        double result;
        long startTime;
        long endTime;


        x = 2;
        n = -2;
        startTime = System.currentTimeMillis();
        result = testMy1(x, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_PowXN My 1 result: " + result + ", during time " + (endTime - startTime));

        x = 100;
        n = (int) (Math.pow(2, 31) - 1);
        startTime = System.currentTimeMillis();
        result = testMy1(x, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_PowXN My 1 result: " + result + ", during time " + (endTime - startTime));

        x = 100;
        n = (int) -(Math.pow(2, 31));
        startTime = System.currentTimeMillis();
        result = testMy1(x, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_PowXN My 1 result: " + result + ", during time " + (endTime - startTime));


        x = 2;
        n = -2;
        startTime = System.currentTimeMillis();
        result = testAnswer1(x, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_PowXN Answer 1 result: " + result + ", during time " + (endTime - startTime));

        x = 100;
        n = (int) (Math.pow(2, 31) - 1);
        startTime = System.currentTimeMillis();
        result = testAnswer1(x, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_PowXN Answer 1 result: " + result + ", during time " + (endTime - startTime));

        x = 100;
        n = (int) -(Math.pow(2, 31));
        startTime = System.currentTimeMillis();
        result = testAnswer1(x, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_PowXN Answer 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static double testMy1(double x, int n) {
        return myPow(x, n);
    }

    private static double testAnswer1(double x, int n) {
        return powAnswer1(x, n);
    }
}
