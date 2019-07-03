package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC204_CountPrimes.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC204_CountPrimesTest {

    public static void main(String[] args) {
        int[] input = new int[]{
                7
        };
        long startTime;
        int result;
        long endTime;

        for (int n : input) {
            startTime = System.currentTimeMillis();
            result = testMy1(n);
            endTime = System.currentTimeMillis();
            System.out.println("CountPrimes My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testAnswer1(n);
            endTime = System.currentTimeMillis();
            System.out.println("CountPrimes Answer 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int n) {
        return getCountPrimesMy1(n);
    }

    private static int testAnswer1(int n) {
        return getCountPrimesAnswer1(n);
    }
}
