package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC106_Odd.getOddMy1;

/**
 * Created by liu on 2016/11/27.
 */
public class ITAC106_OddTest {

    public static void main(String[] args) {
        int n = 10;
        boolean result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(n);
        endTime = System.currentTimeMillis();
        System.out.println("Odd My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testMy1(int n) {
        return getOddMy1(n);
    }

}
