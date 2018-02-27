package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC162_FindPeakElement.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC162_FindPeakElementTest {

    public static void main(String[] args) {
        int[] input = new int[]{
                1, 2, 3, 1
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("FindPeakElement My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] input) {
        return getFindPeakElementMy1(input);
    }
}
