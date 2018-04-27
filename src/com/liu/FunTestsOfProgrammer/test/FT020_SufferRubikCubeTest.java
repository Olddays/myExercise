package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT020_SufferRubikCube.getSufferRubikCubeMy1;
import static com.liu.FunTestsOfProgrammer.exercise.FT020_SufferRubikCube.getSufferRubikCubeMy2;

/**
 * Created by liu on 2018/02/28.
 */
public class FT020_SufferRubikCubeTest {

    public static void main(String[] args) {
        int[][] cubeDataSet = {
                {
                        1, 14, 14, 4
                },
                {
                        1, 14, 14, 4,
                        11, 7, 6, 9,
                        8, 10, 10, 5,
                        13, 2, 3, 15
                },
        };
        int result;
        long startTime;
        long endTime;

        for (int[] cube : cubeDataSet) {
            startTime = System.currentTimeMillis();
//            result = testMy1(cube);
            result = 0;
            endTime = System.currentTimeMillis();
            System.out.println("SufferRubikCube My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(cube);
            endTime = System.currentTimeMillis();
            System.out.println("SufferRubikCube My 2 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int[] cube) {
        return getSufferRubikCubeMy1(cube);
    }

    private static int testMy2(int[] cube) {
        return getSufferRubikCubeMy2(cube);
    }
}
