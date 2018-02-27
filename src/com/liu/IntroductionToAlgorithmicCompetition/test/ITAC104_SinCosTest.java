package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC104_SinCos.getSinCosMy1;

/**
 * Created by baidu on 2016/11/27.
 */
public class ITAC104_SinCosTest {

    public static void main(String[] args) {
        int n = 120;
        double[] result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(n);
        endTime = System.currentTimeMillis();
        System.out.println("SinCos My 1 result.length " + result.length + " during time " + (endTime - startTime));
        for (double d : result) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    private static double[] testMy1(int f) {
        return getSinCosMy1(f);
    }

}
