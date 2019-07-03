package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC189_RotateArray.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC189_RotateArrayTest {

    public static void main(String[] args) {
        int[] input = new int[]{
                1, 2, 3, 4, 5, 6, 7
        };
        int key = 3;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testMy1(input, key);
        endTime = System.currentTimeMillis();
        System.out.println("RotateArray My 1 during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        testMy2(input, key);
        endTime = System.currentTimeMillis();
        System.out.println("RotateArray My 2 during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        testAnswer1(input, key);
        endTime = System.currentTimeMillis();
        System.out.println("RotateArray Answer 1 during time " + (endTime - startTime));
    }

    private static void testMy1(int[] input, int key) {
        getRotateArrayMy1(input, key);
    }

    private static void testMy2(int[] input, int key) {
        getRotateArrayMy2(input, key);
    }

    private static void testAnswer1(int[] input, int key) {
        getRotateArrayAnswer1(input, key);
    }
}
