package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD25_FindMinimumInRotatedSortedArrayII.findMin;

/**
 * Created by Liu on 2020/7/27.
 */
public class TD25_FindMinimumInRotatedSortedArrayII_Test {

    public static void main(String[] args) {
        int[] nums;
        int result;
        long startTime;
        long endTime;


        nums = new int[]{
                1, 3, 5
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD25_FindMinimumInRotatedSortedArrayII My 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{
                2, 2, 2, 0, 1
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD25_FindMinimumInRotatedSortedArrayII My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return findMin(nums);
    }
}
