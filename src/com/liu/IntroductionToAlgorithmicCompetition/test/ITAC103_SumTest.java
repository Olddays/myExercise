package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC103_Sum.getSumMy1;

/**
 * Created by baidu on 2016/11/27.
 */
public class ITAC103_SumTest {

    public static void main(String[] args) {
        int n = 120;
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(n);
        endTime = System.currentTimeMillis();
        System.out.println("Sum My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int f) {
        return getSumMy1(f);
    }

}
