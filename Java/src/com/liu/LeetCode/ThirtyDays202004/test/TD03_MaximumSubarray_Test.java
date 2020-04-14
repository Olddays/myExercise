package com.liu.LeetCode.ThirtyDays202004.test;

import static com.liu.LeetCode.ThirtyDays202004.exercise.TD03_MaximumSubarray.maxSubArray;

public class TD03_MaximumSubarray_Test {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD03_MaximumSubarray My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return maxSubArray(nums);
    }

}
