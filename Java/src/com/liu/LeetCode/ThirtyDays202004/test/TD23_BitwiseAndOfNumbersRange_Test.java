package com.liu.LeetCode.ThirtyDays202004.test;

import static com.liu.LeetCode.ThirtyDays202004.exercise.TD23_BitwiseAndOfNumbersRange.rangeBitwiseAndMy1;
import static com.liu.LeetCode.ThirtyDays202004.exercise.TD23_BitwiseAndOfNumbersRange.rangeBitwiseAndAnswer1;

/**
 * Created by Liu on 2020/4/23.
 */
public class TD23_BitwiseAndOfNumbersRange_Test {

    public static void main(String[] args) {
        int m;
        int n;
        int result;
        long startTime;
        long endTime;


        m = 5;
        n = 7;
        startTime = System.currentTimeMillis();
        result = testMy1(m, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD23_BitwiseAndOfNumbersRange My 1 result " + result + " during time " + (endTime - startTime));
        m = 5;
        n = 7;
        startTime = System.currentTimeMillis();
        result = testAnswer1(m, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD23_BitwiseAndOfNumbersRange Answer 1 result " + result + " during time " + (endTime - startTime));


        m = 2147483646;
        n = 2147483647;
        startTime = System.currentTimeMillis();
        result = testAnswer1(m, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD23_BitwiseAndOfNumbersRange Answer 1 result " + result + " during time " + (endTime - startTime));


        m = 0;
        n = 1;
        startTime = System.currentTimeMillis();
        result = testMy1(m, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD23_BitwiseAndOfNumbersRange My 1 result " + result + " during time " + (endTime - startTime));
        m = 0;
        n = 1;
        startTime = System.currentTimeMillis();
        result = testAnswer1(m, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD23_BitwiseAndOfNumbersRange Answer 1 result " + result + " during time " + (endTime - startTime));

    }

    private static int testMy1(int m, int n) {
        return rangeBitwiseAndMy1(m, n);
    }

    private static int testAnswer1(int m, int n) {
        return rangeBitwiseAndAnswer1(m, n);
    }
}
