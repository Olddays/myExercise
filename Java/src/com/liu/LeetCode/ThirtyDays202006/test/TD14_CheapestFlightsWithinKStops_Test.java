package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD14_CheapestFlightsWithinKStops.findCheapestPriceMy1;
import static com.liu.LeetCode.ThirtyDays202006.exercise.TD14_CheapestFlightsWithinKStops.findCheapestPriceAnswer1;

/**
 * Created by Liu on 2020/6/15.
 */
public class TD14_CheapestFlightsWithinKStops_Test {
    public static void main(String[] args) {
        int n;
        int[][] flights;
        int src;
        int dst;
        int K;
        int result;
        long startTime;
        long endTime;


        n = 3;
        flights = new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500},
        };
        src = 0;
        dst = 2;
        K = 1;
        startTime = System.currentTimeMillis();
        result = testMy1(n, flights, src, dst, K);
        endTime = System.currentTimeMillis();
        System.out.println("TD14_CheapestFlightsWithinKStops My 1 result: " + result + ", during time " + (endTime - startTime));

        n = 3;
        flights = new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500},
        };
        src = 0;
        dst = 2;
        K = 0;
        startTime = System.currentTimeMillis();
        result = testMy1(n, flights, src, dst, K);
        endTime = System.currentTimeMillis();
        System.out.println("TD14_CheapestFlightsWithinKStops My 1 result: " + result + ", during time " + (endTime - startTime));


        n = 3;
        flights = new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500},
        };
        src = 0;
        dst = 2;
        K = 1;
        startTime = System.currentTimeMillis();
        result = testAnswer1(n, flights, src, dst, K);
        endTime = System.currentTimeMillis();
        System.out.println("TD14_CheapestFlightsWithinKStops Answer 1 result: " + result + ", during time " + (endTime - startTime));

        n = 3;
        flights = new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500},
        };
        src = 0;
        dst = 2;
        K = 0;
        startTime = System.currentTimeMillis();
        result = testAnswer1(n, flights, src, dst, K);
        endTime = System.currentTimeMillis();
        System.out.println("TD14_CheapestFlightsWithinKStops Answer 1 result: " + result + ", during time " + (endTime - startTime));

    }

    private static int testMy1(int n, int[][] flights, int src, int dst, int K) {
        return findCheapestPriceMy1(n, flights, src, dst, K);
    }

    private static int testAnswer1(int n, int[][] flights, int src, int dst, int K) {
        return findCheapestPriceAnswer1(n, flights, src, dst, K);
    }
}
