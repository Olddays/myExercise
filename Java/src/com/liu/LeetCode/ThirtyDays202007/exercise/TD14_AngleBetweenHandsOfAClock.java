package com.liu.LeetCode.ThirtyDays202007.exercise;

/**
 * Created by Liu on 2020/7/14.
 */
public class TD14_AngleBetweenHandsOfAClock {
    public static double angleClock(int hour, int minutes) {
        double result;
        double minutesAngle = (double) 360 / (double) 60 * (double) minutes;
        double hourAngle = (double) 360 / (double) 12 * (double) hour + (double) 360 / (double) 12 / (double) 60 * (double) minutes;
        result = Math.abs(minutesAngle - hourAngle);
        if (result > 360 / 2) {
            result = 360 - result;
        }
        return result;
    }
}
