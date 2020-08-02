package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD14_AngleBetweenHandsOfAClock.angleClock;

/**
 * Created by Liu on 2020/7/14.
 */
public class TD14_AngleBetweenHandsOfAClock_Test {

    public static void main(String[] args) {
        int hour;
        int minutes;
        double result;
        long startTime;
        long endTime;


        hour = 12;
        minutes = 30;
        startTime = System.currentTimeMillis();
        result = testMy1(hour, minutes);
        endTime = System.currentTimeMillis();
        System.out.println("TD14_AngleBetweenHandsOfAClock My 1 result: " + result + ", during time " + (endTime - startTime));

        hour = 3;
        minutes = 30;
        startTime = System.currentTimeMillis();
        result = testMy1(hour, minutes);
        endTime = System.currentTimeMillis();
        System.out.println("TD14_AngleBetweenHandsOfAClock My 1 result: " + result + ", during time " + (endTime - startTime));

        hour = 3;
        minutes = 15;
        startTime = System.currentTimeMillis();
        result = testMy1(hour, minutes);
        endTime = System.currentTimeMillis();
        System.out.println("TD14_AngleBetweenHandsOfAClock My 1 result: " + result + ", during time " + (endTime - startTime));

        hour = 4;
        minutes = 50;
        startTime = System.currentTimeMillis();
        result = testMy1(hour, minutes);
        endTime = System.currentTimeMillis();
        System.out.println("TD14_AngleBetweenHandsOfAClock My 1 result: " + result + ", during time " + (endTime - startTime));

        hour = 12;
        minutes = 0;
        startTime = System.currentTimeMillis();
        result = testMy1(hour, minutes);
        endTime = System.currentTimeMillis();
        System.out.println("TD14_AngleBetweenHandsOfAClock My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static double testMy1(int hour, int minutes) {
        return angleClock(hour, minutes);
    }
}
