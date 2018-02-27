package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC495_TeemoAttacking.getTeemoAttackingMy1;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC495_TeemoAttackingTest {

    public static void main(String[] args) {
        int[] timeSeries = {
                1, 2
        };
        int duration = 2;
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(timeSeries, duration);
        endTime = System.currentTimeMillis();
        System.out.println("TeemoAttacking My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] timeSeries, int duration) {
        return getTeemoAttackingMy1(timeSeries, duration);
    }
}
