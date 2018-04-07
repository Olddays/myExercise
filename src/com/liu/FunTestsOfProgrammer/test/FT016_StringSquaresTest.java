package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT016_StringSquares.getStringSquaresMy1;
import static com.liu.FunTestsOfProgrammer.exercise.FT016_StringSquares.getStringSquaresMy2;

/**
 * Created by liu on 2018/02/28.
 */
public class FT016_StringSquaresTest {

    public static void main(String[] args) {
        int[] maxStringSet = new int[]{
                20,
                40,
                60,
                500
        };
        int result;
        long startTime;
        long endTime;

        for (int maxString : maxStringSet) {
            startTime = System.currentTimeMillis();
            result = testMy1(maxString);
            endTime = System.currentTimeMillis();
            System.out.println("StringSquares My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(maxString);
            endTime = System.currentTimeMillis();
            System.out.println("StringSquares My 2 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int maxString) {
        return getStringSquaresMy1(maxString);
    }

    private static int testMy2(int maxString) {
        return getStringSquaresMy2(maxString);
    }
}
