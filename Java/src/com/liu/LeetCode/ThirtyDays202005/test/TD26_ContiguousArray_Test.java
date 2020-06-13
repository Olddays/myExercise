package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD26_ContiguousArray.findMaxLength;

/**
 * Created by Liu on 2020/5/28.
 */
public class TD26_ContiguousArray_Test {
    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 0},
                {0, 0, 1, 0, 0, 0, 1, 1},
                {0, 1, 0},
        };
        int result;
        long startTime;
        long endTime;

        for (int[] nums : numsList) {
            startTime = System.currentTimeMillis();
            result = testMy1(nums);
            endTime = System.currentTimeMillis();
            System.out.println("TD26_ContiguousArray My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int[] nums) {
        return findMaxLength(nums);
    }
}
