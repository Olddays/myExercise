package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC207_Approximation.getApproximationMy1;

/**
 * Created by liu on 2016/11/27.
 */
public class ITAC207_ApproximationTest {

    public static void main(String[] args) {
        long startTime;
        double result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1();
        endTime = System.currentTimeMillis();
        System.out.println("Approximation My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static double testMy1() {
        return getApproximationMy1();
    }

}
