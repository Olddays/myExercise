package com.liu.FunTestsOfProgrammer.test;

import java.util.List;

import static com.liu.FunTestsOfProgrammer.exercise.FT005_PayInCash.getPayInCashMy1;

/**
 * Created by liu on 2018/02/28.
 */
public class FT005_PayInCashTest {

    public static void main(String[] args) {
        int[] numbers = new int[]{
                1000
        };
        int[] maxCounts = new int[]{
                15
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int num = 0; num < numbers.length; num++) {
            int number = numbers[num];
            int maxCount = maxCounts[num];
            startTime = System.currentTimeMillis();
            result = testMy1(number, maxCount);
            endTime = System.currentTimeMillis();
            System.out.println("PayInCash My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
            for (List<Integer> list : result) {
                for (int i : list) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> testMy1(int number, int maxCount) {
        return getPayInCashMy1(number, maxCount);
    }
}
