package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT022_UncrossLine.getUncrossLineMy1;

/**
 * Created by liu on 2018/02/28.
 */
public class FT022_UncrossLineTest {

    public static void main(String[] args) {
        int[] numberSet = {
                6, 16
        };
        int result;
        long startTime;
        long endTime;

        for (int number : numberSet) {
            startTime = System.currentTimeMillis();
            result = testMy1(number);
            endTime = System.currentTimeMillis();
            System.out.println("UncrossLine My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int number) {
        return getUncrossLineMy1(number);
    }
}
