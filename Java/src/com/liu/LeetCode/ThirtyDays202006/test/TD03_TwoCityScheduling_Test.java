package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD03_TwoCityScheduling.twoCitySchedCost;

/**
 * Created by Liu on 2020/6/3.
 */
public class TD03_TwoCityScheduling_Test {
    public static void main(String[] args) {
        int[][] costs;
        int result;
        long startTime;
        long endTime;

        costs = new int[][]{
                {10, 20},
                {30, 200},
                {400, 50},
                {30, 20}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(costs);
        endTime = System.currentTimeMillis();
        System.out.println("TD03_TwoCityScheduling My 1 result " + result + " during time " + (endTime - startTime));

        costs = new int[][]{
                {259, 770},
                {448, 54},
                {926, 667},
                {184, 139},
                {840, 118},
                {577, 469}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(costs);
        endTime = System.currentTimeMillis();
        System.out.println("TD03_TwoCityScheduling My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[][] costs) {
        return twoCitySchedCost(costs);
    }
}
