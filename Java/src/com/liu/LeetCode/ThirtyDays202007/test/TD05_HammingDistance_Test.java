package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD05_HammingDistance.hammingDistance;

/**
 * Created by Liu on 2020/7/6.
 */
public class TD05_HammingDistance_Test {
    public static void main(String[] args) {
        int x;
        int y;
        int result;
        long startTime;
        long endTime;


        x = 1;
        y = 4;
        startTime = System.currentTimeMillis();
        result = testMy1(x, y);
        endTime = System.currentTimeMillis();
        System.out.println("TD05_HammingDistance My 1 result: " + result + ", during time " + (endTime - startTime));

        x = 0;
        y = 4;
        startTime = System.currentTimeMillis();
        result = testMy1(x, y);
        endTime = System.currentTimeMillis();
        System.out.println("TD05_HammingDistance My 1 result: " + result + ", during time " + (endTime - startTime));

        x = 0;
        y = 0;
        startTime = System.currentTimeMillis();
        result = testMy1(x, y);
        endTime = System.currentTimeMillis();
        System.out.println("TD05_HammingDistance My 1 result: " + result + ", during time " + (endTime - startTime));

        x = 0;
        y = (int) (Math.pow(2, 31) - 1);
        startTime = System.currentTimeMillis();
        result = testMy1(x, y);
        endTime = System.currentTimeMillis();
        System.out.println("TD05_HammingDistance My 1 result: " + result + ", during time " + (endTime - startTime));

        x = (int) (Math.pow(2, 31) - 1);
        y = (int) (Math.pow(2, 31) - 1);
        startTime = System.currentTimeMillis();
        result = testMy1(x, y);
        endTime = System.currentTimeMillis();
        System.out.println("TD05_HammingDistance My 1 result: " + result + ", during time " + (endTime - startTime));

    }

    private static int testMy1(int x, int y) {
        return hammingDistance(x, y);
    }

}
