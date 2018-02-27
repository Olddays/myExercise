package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC208_Subsequence.getSubsequenceMy1;

/**
 * Created by baidu on 2016/11/27.
 */
public class ITAC208_SubsequenceTest {

    public static void main(String[] args) {
        int n = 2;
        int m = 4;
        long startTime;
        double result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(n, m);
        endTime = System.currentTimeMillis();
        System.out.println("Subsequence My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static double testMy1(int n, int m) {
        return getSubsequenceMy1(n, m);
    }

}
