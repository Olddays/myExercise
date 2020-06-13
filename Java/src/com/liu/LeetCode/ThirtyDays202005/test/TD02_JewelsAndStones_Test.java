package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD02_JewelsAndStones.numJewelsInStones;

/**
 * Created by Liu on 2020/5/6.
 */
public class TD02_JewelsAndStones_Test {

    public static void main(String[] args) {
        String J;
        String S;
        int result;
        long startTime;
        long endTime;

        J = "";
        S = "";
        startTime = System.currentTimeMillis();
        result = testMy1(J, S);
        endTime = System.currentTimeMillis();
        System.out.println("TD02_JewelsAndStones My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(String J, String S) {
        return numJewelsInStones(J, S);
    }

}
