package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT024_PerfectStrikeOut.getPerfectStrikeOutMy1;
import static com.liu.FunTestsOfProgrammer.exercise.FT024_PerfectStrikeOut.getPerfectStrikeOutMy2;

/**
 * Created by liu on 2018/02/28.
 */
public class FT024_PerfectStrikeOutTest {

    public static void main(String[] args) {
        int[] lengthSet = {
                2,
                2,
                3
        };
        int[] weightSet = {
                1,
                2,
                3
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < lengthSet.length; i++) {
            int length = lengthSet[i];
            int weight = weightSet[i];

            startTime = System.currentTimeMillis();
            result = testMy1(length, weight);
            endTime = System.currentTimeMillis();
            System.out.println("PerfectStrikeOut My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(length, weight);
            endTime = System.currentTimeMillis();
            System.out.println("PerfectStrikeOut My 2 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int length, int weight) {
        return getPerfectStrikeOutMy1(length, weight);
    }

    private static int testMy2(int length, int weight) {
        return getPerfectStrikeOutMy2(length, weight);
    }
}
