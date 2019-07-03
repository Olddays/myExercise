package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC674_LongestContinuousIncreasingSubsequence.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC674_LongestContinuousIncreasingSubsequenceTest {

    public static void main(String[] args) {
        int[] nums = {
//                1, 3, 5, 4, 7
                2, 2, 2, 2, 2
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("LongestContinuousIncreasingSubsequence My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return getLongestContinuousIncreasingSubsequenceMy1(nums);
    }
}
