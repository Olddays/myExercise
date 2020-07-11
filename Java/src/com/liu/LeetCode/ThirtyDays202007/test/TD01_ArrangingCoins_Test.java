package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD01_ArrangingCoins.arrangeCoinsMy1;
import static com.liu.LeetCode.ThirtyDays202007.exercise.TD01_ArrangingCoins.arrangeCoinsMy2;

/**
 * Created by Liu on 2020/7/1.
 */
public class TD01_ArrangingCoins_Test {
    public static void main(String[] args) {
        int n;
        int result;
        long startTime;
        long endTime;


        n = 5;
        startTime = System.currentTimeMillis();
        result = testMy1(n);
        endTime = System.currentTimeMillis();
        System.out.println("TD01_ArrangingCoins My 1 result: " + result + ", during time " + (endTime - startTime));

        n = 8;
        startTime = System.currentTimeMillis();
        result = testMy1(n);
        endTime = System.currentTimeMillis();
        System.out.println("TD01_ArrangingCoins My 1 result: " + result + ", during time " + (endTime - startTime));

        n = 1;
        startTime = System.currentTimeMillis();
        result = testMy1(n);
        endTime = System.currentTimeMillis();
        System.out.println("TD01_ArrangingCoins My 1 result: " + result + ", during time " + (endTime - startTime));

        n = 0;
        startTime = System.currentTimeMillis();
        result = testMy1(n);
        endTime = System.currentTimeMillis();
        System.out.println("TD01_ArrangingCoins My 1 result: " + result + ", during time " + (endTime - startTime));

        n = 5;
        startTime = System.currentTimeMillis();
        result = testMy2(n);
        endTime = System.currentTimeMillis();
        System.out.println("TD01_ArrangingCoins My 2 result: " + result + ", during time " + (endTime - startTime));

        n = 8;
        startTime = System.currentTimeMillis();
        result = testMy2(n);
        endTime = System.currentTimeMillis();
        System.out.println("TD01_ArrangingCoins My 2 result: " + result + ", during time " + (endTime - startTime));

        n = 1;
        startTime = System.currentTimeMillis();
        result = testMy2(n);
        endTime = System.currentTimeMillis();
        System.out.println("TD01_ArrangingCoins My 2 result: " + result + ", during time " + (endTime - startTime));

        n = 0;
        startTime = System.currentTimeMillis();
        result = testMy2(n);
        endTime = System.currentTimeMillis();
        System.out.println("TD01_ArrangingCoins My 2 result: " + result + ", during time " + (endTime - startTime));

        n = Integer.MAX_VALUE;
        startTime = System.currentTimeMillis();
        result = testMy2(n);
        endTime = System.currentTimeMillis();
        System.out.println("TD01_ArrangingCoins My 2 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(int n) {
        return arrangeCoinsMy1(n);
    }

    private static int testMy2(int n) {
        return arrangeCoinsMy2(n);
    }
}
