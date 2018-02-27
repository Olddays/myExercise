package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC209_MinimumSizeSubarraySum.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC209_MinimumSizeSubarraySumTest {

    public static void main(String[] args) {
        int[] input = new int[]{
//                2, 3, 1, 2, 4, 3
//                1, 2, 3, 4, 5
//                1, 5, 2
                10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8
        };
//        int sum = 7;
//        int sum = 11;
//        int sum = 4;
        int sum = 80;
        long startTime;
        int result;
        long endTime;


        startTime = System.currentTimeMillis();
        result = testMy1(sum, input);
        endTime = System.currentTimeMillis();
        System.out.println("MinimumSizeSubarraySum My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(sum, input);
        endTime = System.currentTimeMillis();
        System.out.println("MinimumSizeSubarraySum Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int key, int[] input) {
        return getMinimumSizeSubarraySumMy1(key, input);
    }

    private static int testAnswer1(int key, int[] input) {
        return getMinimumSizeSubarraySumAnswer1(key, input);
    }
}
