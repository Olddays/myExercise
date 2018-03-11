package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT009_AloneMenAndWomen.getAloneMenAndWomenMy1;

/**
 * Created by liu on 2018/02/28.
 */
public class FT009_AloneMenAndWomenTest {

    public static void main(String[] args) {
        int[] mens = new int[]{
                20
        };
        int[] womens = new int[]{
                10
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < mens.length; i++) {
            int men = mens[i];
            int women = womens[i];
            startTime = System.currentTimeMillis();
            result = testMy1(men, women);
            endTime = System.currentTimeMillis();
            System.out.println("AloneMenAndWomen My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int men, int women) {
        return getAloneMenAndWomenMy1(men, women);
    }
}
