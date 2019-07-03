package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC670_MaximumSwap.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC670_MaximumSwapTest {

    public static void main(String[] args) {
//        int sum = 21;
//        int sum = 2736;
//        int sum = 1993;
        int sum = 98368;
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(sum);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumSwap My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(sum);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumSwap My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy3(sum);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumSwap My 3 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(sum);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumSwap Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int sum) {
        return getMaximumSwapMy1(sum);
    }

    private static int testMy2(int sum) {
        return getMaximumSwapMy2(sum);
    }

    private static int testMy3(int sum) {
        return getMaximumSwapMy3(sum);
    }

    private static int testAnswer1(int sum) {
        return getMaximumSwapAnswer1(sum);
    }
}
