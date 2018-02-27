package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC201_Digit.getDigitMy1;

/**
 * Created by baidu on 2016/11/27.
 */
public class ITAC201_DigitTest {

    public static void main(String[] args) {
        int n = 2100;
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(n);
        endTime = System.currentTimeMillis();
        System.out.println("Digit My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int n) {
        return getDigitMy1(n);
    }

}
