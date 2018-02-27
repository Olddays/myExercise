package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC110_Year.getYearMy1;

/**
 * Created by baidu on 2016/11/27.
 */
public class ITAC110_YearTest {

    public static void main(String[] args) {
        int year = 2100;
        String result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(year);
        endTime = System.currentTimeMillis();
        System.out.println("Year My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static String testMy1(int year) {
        return getYearMy1(year);
    }

}
