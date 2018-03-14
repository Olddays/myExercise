package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT012_SquareRootNumber.getSquareRootNumberMy1;

/**
 * Created by liu on 2018/02/28.
 */
public class FT012_SquareRootNumberTest {

    public static void main(String[] args) {
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1();
        endTime = System.currentTimeMillis();
        System.out.println("SquareRootNumber My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1() {
        return getSquareRootNumberMy1();
    }
}
