package com.liu.IntroductionToAlgorithmicCompetition.test;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC107_Discount.getDiscountMy1;

/**
 * Created by liu on 2016/11/27.
 */
public class ITAC107_DiscountTest {

    public static void main(String[] args) {
        int n = 10;
        double result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(n);
        endTime = System.currentTimeMillis();
        System.out.println("Discount My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static double testMy1(int n) {
        return getDiscountMy1(n);
    }

}
