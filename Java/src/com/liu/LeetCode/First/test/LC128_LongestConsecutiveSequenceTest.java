package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC128_LongestConsecutiveSequence.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC128_LongestConsecutiveSequenceTest {

    public static void main(String[] args) {
        int[] input = new int[]{
                100, 4, 200, 1, 3, 2
//                0, 0
//                1, 2, 0, 1
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("LongestConsecutiveSequence My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(input);
        endTime = System.currentTimeMillis();
        System.out.println("LongestConsecutiveSequence Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] input) {
        return getLongestConsecutiveSequenceMy1(input);
    }

    private static int testAnswer1(int[] input) {
        return getLongestConsecutiveSequenceAnswer1(input);
    }
}
