package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC102_Temperature.*;

/**
 * Created by liu on 2016/11/27.
 */
public class ITAC102_TemperatureTest {

    public static void main(String[] args) {
        int f = 120;
        double result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(f);
        endTime = System.currentTimeMillis();
        System.out.println("Temperature My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static double testMy1(int f) {
        return getTemperatureMy1(f);
    }

}
