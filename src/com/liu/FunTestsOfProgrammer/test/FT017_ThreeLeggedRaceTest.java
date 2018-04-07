package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT017_ThreeLeggedRace.getThreeLeggedRaceMy1;
import static com.liu.FunTestsOfProgrammer.exercise.FT017_ThreeLeggedRace.getThreeLeggedRaceMy2;

/**
 * Created by liu on 2018/02/28.
 */
public class FT017_ThreeLeggedRaceTest {

    public static void main(String[] args) {
        int[] maxStringSet = new int[]{
                4,
                30
        };
        int result;
        long startTime;
        long endTime;

        for (int maxString : maxStringSet) {
            startTime = System.currentTimeMillis();
            result = testMy1(maxString);
            endTime = System.currentTimeMillis();
            System.out.println("ThreeLeggedRace My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(maxString);
            endTime = System.currentTimeMillis();
            System.out.println("ThreeLeggedRace My 2 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int maxString) {
        return getThreeLeggedRaceMy1(maxString);
    }

    private static int testMy2(int maxString) {
        return getThreeLeggedRaceMy2(maxString);
    }
}
