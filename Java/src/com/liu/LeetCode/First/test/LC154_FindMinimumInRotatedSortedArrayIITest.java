package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC154_FindMinimumInRotatedSortedArrayII.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC154_FindMinimumInRotatedSortedArrayIITest {

    public static void main(String[] args) {
        int[] input = new int[]{
                4, 5, 6, 7, 0, 1, 2
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("FindMinimumInRotatedSortedArrayII My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] input) {
        return getFindMinimumInRotatedSortedArrayIIMy1(input);
    }
}
