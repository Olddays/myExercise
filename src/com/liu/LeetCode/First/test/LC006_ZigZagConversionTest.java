package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC006_ZigZagConversion.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC006_ZigZagConversionTest {
    public static void main(String[] args) {
        String inputString = "PAYPALISHIRING";
//        String inputString = "ABCDEF";
//        String inputString = ""; // 注意边界情况
        int numRows = 3;
//        int numRows = 1; // 注意边界情况
//        int numRows = 2; // 方法1会crash
//        int numRows = 5; // 方法1会crash
        String result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(inputString, numRows);
        endTime = System.currentTimeMillis();
        System.out.println("ZigZagConversion My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(inputString, numRows);
        endTime = System.currentTimeMillis();
        System.out.println("ZigZagConversion My 2 result " + result + " during time " + (endTime - startTime));
    }

    private static String testMy1(String inputString, int numRows) {
        return getZigZagConversionMy1(inputString, numRows);
    }

    private static String testMy2(String inputString, int numRows) {
        return getZigZagConversionMy2(inputString, numRows);
    }
}
