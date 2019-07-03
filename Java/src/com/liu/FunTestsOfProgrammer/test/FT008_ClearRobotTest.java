package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT008_ClearRobot.getClearRobotMy1;

/**
 * Created by liu on 2018/02/28.
 */
public class FT008_ClearRobotTest {

    public static void main(String[] args) {
        int[] steps = new int[]{
                4, 12
        };
        int result;
        long startTime;
        long endTime;

        for (int step : steps) {
            startTime = System.currentTimeMillis();
            result = testMy1(step);
            endTime = System.currentTimeMillis();
            System.out.println("ClearRobot My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int step) {
        return getClearRobotMy1(step);
    }
}
