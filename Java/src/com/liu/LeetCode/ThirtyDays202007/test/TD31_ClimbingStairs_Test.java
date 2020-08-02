package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD31_ClimbingStairs.climbStairs;

/**
 * Created by Liu on 2020/7/31.
 */
public class TD31_ClimbingStairs_Test {

    public static void main(String[] args) {
        int n;
        int result;
        long startTime;
        long endTime;


        for (n = 1; n <= 45; n++) {
            startTime = System.currentTimeMillis();
            result = testMy1(n);
            endTime = System.currentTimeMillis();
            System.out.println("TD31_ClimbingStairs My 1, n: " + n + ", result: " + result + ", during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int n) {
        return climbStairs(n);
    }
}
