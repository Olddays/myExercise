package com.liu.LeetCode.ThirtyDays202004.test;

import static com.liu.LeetCode.ThirtyDays202004.exercise.TD12_LastStoneWeight.lastStoneWeight;

public class TD12_LastStoneWeight_Test {
    public static void main(String[] args) {
        int[] nums;
        int result;
        long startTime;
        long endTime;

        nums = new int[]{2, 7, 4, 1, 8, 1};
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD12_LastStoneWeight My 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{7, 1, 5, 3, 6, 4};
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD12_LastStoneWeight My 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{1, 2, 3, 4, 5};
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD12_LastStoneWeight My 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{1, 3};
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD12_LastStoneWeight My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return lastStoneWeight(nums);
    }
}
