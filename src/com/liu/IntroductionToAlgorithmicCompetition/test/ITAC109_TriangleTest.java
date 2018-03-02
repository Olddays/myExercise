package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC109_Triangle.getTriangleMy1;

/**
 * Created by liu on 2016/11/27.
 */
public class ITAC109_TriangleTest {

    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        int z = 5;
        String result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(x, y, z);
        endTime = System.currentTimeMillis();
        System.out.println("Triangle My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static String testMy1(int x, int y, int z) {
        return getTriangleMy1(x, y, z);
    }

}
