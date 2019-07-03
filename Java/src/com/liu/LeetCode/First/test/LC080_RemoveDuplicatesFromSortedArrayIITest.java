package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC080_RemoveDuplicatesFromSortedArrayII.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC080_RemoveDuplicatesFromSortedArrayIITest {

    public static void main(String[] args) {
        int[] input = new int[]{
                1, 1, 1, 2, 2, 3
        };
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("RemoveDuplicatesFromSortedArrayII My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] input) {
        return getRemoveDuplicatesFromSortedArrayIIMy1(input);
    }
}
