package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD27_PerfectSquares.numSquares;

/**
 * Created by Liu on 2020/6/27.
 */
public class TD27_PerfectSquares_Test {

    public static void main(String[] args) {
        int input;
        int result;
        long startTime;
        long endTime;


        input = 12;
        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("TD09_IsSubsequence My 1 result " + result + " during time " + (endTime - startTime));

        input = 13;
        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("TD09_IsSubsequence My 1 result " + result + " during time " + (endTime - startTime));

    }

    private static int testMy1(int input) {
        return numSquares(input);
    }
}
