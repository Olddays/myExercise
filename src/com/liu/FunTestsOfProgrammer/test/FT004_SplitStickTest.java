package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT004_SplitStick.getSplitStickMy1;
import static com.liu.FunTestsOfProgrammer.exercise.FT004_SplitStick.getSplitStickMy2;

/**
 * Created by liu on 2018/02/28.
 */
public class FT004_SplitStickTest {

    public static void main(String[] args) {
        int[] sticks = new int[]{
                8, 20, 100
        };
        int[] numbers = new int[]{
                3, 3, 5
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < sticks.length; i++) {
            int stickLength = sticks[i];
            int number = numbers[i];

            startTime = System.currentTimeMillis();
            result = testMy1(stickLength, number);
            endTime = System.currentTimeMillis();
            System.out.println("SplitStick My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(stickLength, number);
            endTime = System.currentTimeMillis();
            System.out.println("SplitStick My 2 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int stickLength, int number) {
        return getSplitStickMy1(stickLength, number);
    }

    private static int testMy2(int stickLength, int number) {
        return getSplitStickMy2(stickLength, number);
    }
}
