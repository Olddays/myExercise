package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT023_WinnerTakesAllTwentyOne.getWinnerTakesAllTwentyOneMy1;
import static com.liu.FunTestsOfProgrammer.exercise.FT023_WinnerTakesAllTwentyOne.getWinnerTakesAllTwentyOneMy2;

/**
 * Created by liu on 2018/02/28.
 */
public class FT023_WinnerTakesAllTwentyOneTest {

    public static void main(String[] args) {
        int[] startNumSet = {
                1,
                10
        };
        int[] depthSet = {
                4,
                24
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < startNumSet.length; i++) {
            int startNum = startNumSet[i];
            int depth = depthSet[i];

            startTime = System.currentTimeMillis();
            result = testMy1(startNum, depth);
            endTime = System.currentTimeMillis();
            System.out.println("WinnerTakesAllTwentyOne My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(startNum, depth);
            endTime = System.currentTimeMillis();
            System.out.println("WinnerTakesAllTwentyOne My 2 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int startNum, int depth) {
        return getWinnerTakesAllTwentyOneMy1(startNum, depth);
    }

    private static int testMy2(int startNum, int depth) {
        return getWinnerTakesAllTwentyOneMy2(startNum, depth);
    }
}
