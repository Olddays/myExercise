package com.liu.LeetApp.test;

import static com.liu.LeetApp.exercise.LA004_AddBinary.*;

/**
 * Created by liu on 2016/11/30.
 */
public class LA004_AddBinaryTest {

    public static void main(String[] args) {
        String input1 = "1111111111111111111110000111";
        String input2 = "111111110001010110111011111011101";
        String result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input1, input2);
        endTime = System.currentTimeMillis();
        System.out.println("getAddBinary my 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(input1, input2);
        endTime = System.currentTimeMillis();
        System.out.println("getAddBinary my 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy3(input1, input2);
        endTime = System.currentTimeMillis();
        System.out.println("getAddBinary my 3 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy4(input1, input2);
        endTime = System.currentTimeMillis();
        System.out.println("getAddBinary my 4 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer(input1, input2);
        endTime = System.currentTimeMillis();
        System.out.println("getAddBinary answer result " + result + " during time " + (endTime - startTime));
    }

    private static String testMy1(String input1, String input2) {
        return getAddBinaryMy1(input1, input2);
    }

    private static String testMy2(String input1, String input2) {
        return getAddBinaryMy2(input1, input2);
    }

    private static String testMy3(String input1, String input2) {
        return getAddBinaryMy3(input1, input2);
    }

    private static String testMy4(String input1, String input2) {
        return getAddBinaryMy4(input1, input2);
    }

    private static String testAnswer(String input1, String input2) {
        return getAddBinaryAnswer(input1, input2);
    }
}
