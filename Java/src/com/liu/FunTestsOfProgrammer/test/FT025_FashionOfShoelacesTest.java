package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT025_FashionOfShoelaces.getFashionOfShoelacesMy1;

/**
 * Created by liu on 2018/02/28.
 */
public class FT025_FashionOfShoelacesTest {

    public static void main(String[] args) {
        int[] holeCountSet = {
                12
        };
        int result;
        long startTime;
        long endTime;

        for (int holeCount : holeCountSet) {
            startTime = System.currentTimeMillis();
            result = testMy1(holeCount);
            endTime = System.currentTimeMillis();
            System.out.println("FashionOfShoelaces My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int holeCount) {
        return getFashionOfShoelacesMy1(holeCount);
    }
}
