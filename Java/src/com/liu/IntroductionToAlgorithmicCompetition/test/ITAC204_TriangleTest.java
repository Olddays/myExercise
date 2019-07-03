package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC204_Triangle.getTriangleMy1;

/**
 * Created by liu on 2016/11/27.
 */
public class ITAC204_TriangleTest {

    public static void main(String[] args) {
        int n = 5;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testMy1(n);
        endTime = System.currentTimeMillis();
        System.out.println("Triangle My 1 during time " + (endTime - startTime));
    }

    private static void testMy1(int n) {
        getTriangleMy1(n);
    }

}
