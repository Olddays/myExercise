package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC206_Harmony.getHarmonyMy1;

/**
 * Created by liu on 2016/11/27.
 */
public class ITAC206_HarmonyTest {

    public static void main(String[] args) {
        int n = 3;
        long startTime;
        double result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(n);
        endTime = System.currentTimeMillis();
        System.out.println("Harmony My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static double testMy1(int n) {
        return getHarmonyMy1(n);
    }

}
