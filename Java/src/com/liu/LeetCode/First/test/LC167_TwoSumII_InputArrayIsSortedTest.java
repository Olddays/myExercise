package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC167_TwoSumII_InputArrayIsSorted.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC167_TwoSumII_InputArrayIsSortedTest {

    public static void main(String[] args) {
        int[] input = new int[]{
                2, 7, 11, 15
        };
        int target = 9;
        long startTime;
        int[] result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("TwoSumII_InputArrayIsSorted My 1 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] testMy1(int[] input, int target) {
        return getTwoSumII_InputArrayIsSortedMy1(input, target);
    }
}
