package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD19_AddBinary.addBinary;

/**
 * Created by Liu on 2020/7/20.
 */
public class TD19_AddBinary_Test {

    public static void main(String[] args) {
        String a;
        String b;
        String result;
        long startTime;
        long endTime;


        a = "11";
        b = "1";
        startTime = System.currentTimeMillis();
        result = testMy1(a, b);
        endTime = System.currentTimeMillis();
        System.out.println("TD19_AddBinary My 1 result: " + result + ", during time " + (endTime - startTime));

        a = "1010";
        b = "1011";
        startTime = System.currentTimeMillis();
        result = testMy1(a, b);
        endTime = System.currentTimeMillis();
        System.out.println("TD19_AddBinary My 1 result: " + result + ", during time " + (endTime - startTime));

    }

    private static String testMy1(String a, String b) {
        return addBinary(a, b);
    }

}
