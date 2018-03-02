package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC105_Distance.getDistanceMy1;

/**
 * Created by liu on 2016/11/27.
 */
public class ITAC105_DistanceTest {

    public static void main(String[] args) {
        int x1 = 0;
        int x2 = 3;
        int y1 = 0;
        int y2 = 4;
        double result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(x1, y1, x2, y2);
        endTime = System.currentTimeMillis();
        System.out.println("Distance My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static double testMy1(int x1, int y1, int x2, int y2) {
        return getDistanceMy1(x1, y1, x2, y2);
    }

}
