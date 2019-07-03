package com.liu.FunTestsOfProgrammer.test;

import java.util.List;

import static com.liu.FunTestsOfProgrammer.exercise.FT006_CollatzConjecture.getCollatzConjectureMy1;

/**
 * Created by liu on 2018/02/28.
 */
public class FT006_CollatzConjectureTest {

    public static void main(String[] args) {
        int[] numbers = new int[]{
                10000
        };
        int result;
        long startTime;
        long endTime;

        for (int number : numbers) {
            startTime = System.currentTimeMillis();
            result = testMy1(number);
            endTime = System.currentTimeMillis();
            System.out.println("CollatzConjecture My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int number) {
        return getCollatzConjectureMy1(number);
    }
}
