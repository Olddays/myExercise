package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT026_EfficientMultistoreyParkingGarage.getEfficientMultistoreyParkingGarageMy1;

/**
 * Created by liu on 2018/02/28.
 */
public class FT026_EfficientMultistoreyParkingGarageTest {

    public static void main(String[] args) {
        int[][] widthAndHeightSet = {
                {3, 2},
                {10, 10}
        };
        int result;
        long startTime;
        long endTime;

        for (int[] widthAndHeight : widthAndHeightSet) {
            int width = widthAndHeight[0];
            int height = widthAndHeight[1];
            startTime = System.currentTimeMillis();
            result = testMy1(width, height);
            endTime = System.currentTimeMillis();
            System.out.println("EfficientMultistoreyParkingGarage My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int width, int height) {
        return getEfficientMultistoreyParkingGarageMy1(width, height);
    }
}
