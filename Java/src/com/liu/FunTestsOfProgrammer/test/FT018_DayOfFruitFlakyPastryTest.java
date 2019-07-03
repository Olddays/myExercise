package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT018_DayOfFruitFlakyPastry.getDayOfFruitFlakyPastryMy1;
import static com.liu.FunTestsOfProgrammer.exercise.FT018_DayOfFruitFlakyPastry.getDayOfFruitFlakyPastryMy2;

/**
 * Created by liu on 2018/02/28.
 */
public class FT018_DayOfFruitFlakyPastryTest {

    public static void main(String[] args) {
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
//        result = testMy1();
        result = 0;
        endTime = System.currentTimeMillis();
        System.out.println("DayOfFruitFlakyPastry My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2();
        endTime = System.currentTimeMillis();
        System.out.println("DayOfFruitFlakyPastry My 2 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1() {
        return getDayOfFruitFlakyPastryMy1();
    }

    private static int testMy2() {
        return getDayOfFruitFlakyPastryMy2();
    }
}
