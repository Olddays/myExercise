package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT019_SixDegreesOfSeparation.getSixDegreesOfSeparationMy1;

/**
 * Created by liu on 2018/02/28.
 */
public class FT019_SixDegreesOfSeparationTest {

    public static void main(String[] args) {
        int[] compositeNumCountSet = {
                7
        };
        int[] layerSet = {
                6
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < compositeNumCountSet.length; i++) {
            int compositeNumCount = compositeNumCountSet[i];
            int layer = layerSet[i];
            startTime = System.currentTimeMillis();
            result = testMy1(compositeNumCount, layer);
            endTime = System.currentTimeMillis();
            System.out.println("SixDegreesOfSeparation My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int compositeNumCount, int layer) {
        return getSixDegreesOfSeparationMy1(compositeNumCount, layer);
    }
}
