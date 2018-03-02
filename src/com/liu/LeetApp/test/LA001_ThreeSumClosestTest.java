package com.liu.LeetApp.test;

import static com.liu.LeetApp.exercise.LA001_ThreeSumClosest.*;

/**
 * Created by liu on 2016/11/27.
 */
public class LA001_ThreeSumClosestTest {

    public static void main(String[] args) {
        int[] input = new int[]{-1, 2, 1, -4};
        int target = 1;
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("getThreeSumClosest My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("getThreeSumClosest My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("getThreeSumClosest My Answer result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] input, int target) {
        return getThreeSumClosestMy1(input, target);
    }

    private static int testMy2(int[] input, int target) {
        return getThreeSumClosestMy2(input, target);
    }

    private static int testAnswer(int[] input, int target) {
        return getThreeSumClosestAnswer(input, target);
    }
}
