package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT015_GoStairs.getGoStairsMy1;
import static com.liu.FunTestsOfProgrammer.exercise.FT015_GoStairs.getGoStairsMy2;

/**
 * Created by liu on 2018/02/28.
 */
public class FT015_GoStairsTest {

    public static void main(String[] args) {
        int[] stairList = new int[]{
                4,
                10,
                20
        };
        int[][] usableStepSet = new int[][]{
                {1, 2, 3},
                {1, 2, 3, 4},
                {1, 2, 3}
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < stairList.length; i++) {
            int stairs = stairList[i];
            int[] usableStep = usableStepSet[i];

            startTime = System.currentTimeMillis();
            result = testMy1(stairs, usableStep);
            endTime = System.currentTimeMillis();
            System.out.println("GoStairs My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(stairs, usableStep);
            endTime = System.currentTimeMillis();
            System.out.println("GoStairs My 2 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int stairs, int[] usableStep) {
        return getGoStairsMy1(stairs, usableStep);
    }

    private static int testMy2(int stairs, int[] usableStep) {
        return getGoStairsMy2(stairs, usableStep);
    }
}
