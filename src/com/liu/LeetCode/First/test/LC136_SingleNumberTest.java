package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC136_SingleNumber.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC136_SingleNumberTest {

    public static void main(String[] args) {
        int[] input = new int[]{
                17, 12, 5, -6, 12, 4, 17, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("SingleNumber My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] input) {
        return getSingleNumberMy1(input);
    }
}
