package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD15_MaximumSumCircularSubarray.maxSubarraySumCircularMy1;
import static com.liu.LeetCode.ThirtyDays202005.exercise.TD15_MaximumSumCircularSubarray.maxSubarraySumCircularMy2;

/**
 * Created by Liu on 2020/5/15.
 */
public class TD15_MaximumSumCircularSubarray_Test {
    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {5, -3, 5},
                {1, -2, 3, -2},
                {3, -1, 2, -1}
        };
        int result;
        long startTime;
        long endTime;

        for (int[] nums : numsSet) {
            startTime = System.currentTimeMillis();
            result = testMy1(nums);
            endTime = System.currentTimeMillis();
            System.out.println("TD15_MaximumSumCircularSubarray My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(nums);
            endTime = System.currentTimeMillis();
            System.out.println("TD15_MaximumSumCircularSubarray My 2 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int[] nums) {
        return maxSubarraySumCircularMy1(nums);
    }

    private static int testMy2(int[] nums) {
        return maxSubarraySumCircularMy2(nums);
    }

}
