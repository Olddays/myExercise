package com.liu.LeetCode.First.test;


import static com.liu.LeetCode.First.exercise.LC007_ReverseInteger.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC007_ReverseIntegerTest {
    public static void main(String[] args) {
        int input = -312;
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("ReverseInteger My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int input) {
        return getReverseIntegerMy1(input);
    }
}
