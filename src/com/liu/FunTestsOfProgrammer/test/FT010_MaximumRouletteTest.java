package com.liu.FunTestsOfProgrammer.test;

import java.util.List;

import static com.liu.FunTestsOfProgrammer.exercise.FT010_MaximumRoulette.getMaximumRouletteMy1;

/**
 * Created by liu on 2018/02/28.
 */
public class FT010_MaximumRouletteTest {

    public static void main(String[] args) {
        int[] minNs = new int[]{
                2
        };
        int[] maxNs = new int[]{
                36
        };
        List<Integer> result;
        long startTime;
        long endTime;

        for (int i = 0; i < maxNs.length; i++) {
            int minN = minNs[i];
            int maxN = maxNs[i];
            startTime = System.currentTimeMillis();
            result = testMy1(minN, maxN);
            endTime = System.currentTimeMillis();
            System.out.println("MaximumRoulette My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static List<Integer> testMy1(int minN, int maxN) {
        return getMaximumRouletteMy1(minN, maxN);
    }
}
