package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC205_Stat.getStatMy1;

/**
 * Created by liu on 2016/11/27.
 */
public class ITAC205_StatTest {

    public static void main(String[] args) {
        int[] nums = {
                1, 2, 3, 4, 5
        };
        int m = 5;
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, m);
        endTime = System.currentTimeMillis();
        System.out.println("Stat My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums, int m) {
        return getStatMy1(nums, m);
    }

}
