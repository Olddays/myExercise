package com.liu.LeetCode.ThirtyDays202004.test;

import static com.liu.LeetCode.ThirtyDays202004.exercise.TD13_ContiguousArray.findMaxLength;

public class TD13_ContiguousArray_Test {

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
            System.out.println("TD13_ContiguousArray My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int[] nums) {
        return findMaxLength(nums);
    }

}
