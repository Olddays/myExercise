package com.liu.FunTestsOfProgrammer.test;

import java.util.List;

import static com.liu.FunTestsOfProgrammer.exercise.FT011_FibonacciSequence.getFibonacciSequenceMy1;

/**
 * Created by liu on 2018/02/28.
 */
public class FT011_FibonacciSequenceTest {

    public static void main(String[] args) {
        int[] resultSizes = new int[]{
                2, 5, 7, 12
        };
        List<Long> result;
        long startTime;
        long endTime;

        for (int resultSize : resultSizes) {
            startTime = System.currentTimeMillis();
            result = testMy1(resultSize);
            endTime = System.currentTimeMillis();
            System.out.println("FibonacciSequence My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
            for (long num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static List<Long> testMy1(int resultSize) {
        return getFibonacciSequenceMy1(resultSize);
    }
}
