package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD23_SingleNumberIII.singleNumber;

/**
 * Created by Liu on 2020/7/23.
 */
public class TD23_SingleNumberIII_Test {
    public static void main(String[] args) {
        int[] nums;
        int[] result;
        long startTime;
        long endTime;


        nums = new int[]{
                0, 1, 1, 2
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD23_SingleNumberIII My 1 result size: " + result.length + ", during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        nums = new int[]{
                1, 2, 1, 3, 2, 5
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD23_SingleNumberIII My 1 result size: " + result.length + ", during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] testMy1(int[] nums) {
        return singleNumber(nums);
    }
}
