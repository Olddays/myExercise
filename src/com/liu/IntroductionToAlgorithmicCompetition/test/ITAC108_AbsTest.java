package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC108_Abs.getAbsMy1;

/**
 * Created by baidu on 2016/11/27.
 */
public class ITAC108_AbsTest {

    public static void main(String[] args) {
        double n = -10.8976;
        double result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(n);
        endTime = System.currentTimeMillis();
        System.out.println("Abs My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static double testMy1(double n) {
        return getAbsMy1(n);
    }

}
