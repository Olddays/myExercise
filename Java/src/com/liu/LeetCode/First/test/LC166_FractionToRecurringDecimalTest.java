package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC166_FractionToRecurringDecimal.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC166_FractionToRecurringDecimalTest {

    public static void main(String[] args) {
        int[] numerators = {
                1, 1, 1, 2, 2, 1, 1, 1, 1
        };
        int[] denominators = {
                333, 99, 2, 1, 3, 5, 6, 8, 90
        };
        long startTime;
        String result;
        long endTime;

        for (int i = 0; i < numerators.length; i++) {
            int numerator = numerators[i];
            int denominator = denominators[i];

            startTime = System.currentTimeMillis();
            result = testMy1(numerator, denominator);
            endTime = System.currentTimeMillis();
            System.out.println("FractionToRecurringDecimal My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testAnswer1(numerator, denominator);
            endTime = System.currentTimeMillis();
            System.out.println("FractionToRecurringDecimal Answer 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static String testMy1(int numerator, int denominator) {
        return getFractionToRecurringDecimalMy1(numerator, denominator);
    }

    private static String testAnswer1(int numerator, int denominator) {
        return getFractionToRecurringDecimalAnswer1(numerator, denominator);
    }
}
