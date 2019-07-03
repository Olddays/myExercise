package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC101_Average.getAverageMy1;

/**
 * Created by liu on 2016/11/27.
 */
public class ITAC101_AverageTest {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        double result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("Average My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static double testMy1(int[] nums) {
        return getAverageMy1(nums);
    }

}
