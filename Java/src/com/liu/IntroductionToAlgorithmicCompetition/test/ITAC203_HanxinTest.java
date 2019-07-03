package com.liu.IntroductionToAlgorithmicCompetition.test;

import java.util.List;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC203_Hanxin.getHanxinMy1;

/**
 * Created by liu on 2016/11/27.
 */
public class ITAC203_HanxinTest {

    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        int c = 6;
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(a, b, c);
        endTime = System.currentTimeMillis();
        System.out.println("Hanxin My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int a, int b, int c) {
        return getHanxinMy1(a, b, c);
    }

}
