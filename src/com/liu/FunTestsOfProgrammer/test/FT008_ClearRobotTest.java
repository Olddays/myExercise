package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT008_ClearRobot.getClearRobotMy1;
import static com.liu.FunTestsOfProgrammer.exercise.FT008_ClearRobot.getClearRobotMy2;

/**
 * Created by liu on 2018/02/28.
 */
public class FT008_ClearRobotTest {

    public static void main(String[] args) {
        int[] staps = new int[]{
                9, 12
        };
        int result;
        long startTime;
        long endTime;

        for (int num = 0; num < staps.length; num++) {
            int stap = staps[num];
            startTime = System.currentTimeMillis();
            result = testMy1(stap);
            endTime = System.currentTimeMillis();
            System.out.println("ClearRobot My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(stap);
            endTime = System.currentTimeMillis();
            System.out.println("ClearRobot My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int stap) {
        return getClearRobotMy1(stap);
    }

    private static int testMy2(int stap) {
        return getClearRobotMy2(stap);
    }
}
