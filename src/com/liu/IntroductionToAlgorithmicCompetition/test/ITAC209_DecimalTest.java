package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC209_Decimal.getDecimalMy1;

/**
 * Created by baidu on 2016/11/27.
 */
public class ITAC209_DecimalTest {

    public static void main(String[] args) {
        int a = 1;
        int b = 6;
        int c = 4;
        long startTime;
        double result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(a, b, c);
        endTime = System.currentTimeMillis();
        System.out.println("Decimal My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static double testMy1(int a, int b, int c) {
        return getDecimalMy1(a, b, c);
    }

}
