package com.liu.LeetCode.ThirtyDays202004.test;

import static com.liu.LeetCode.ThirtyDays202004.exercise.TD15_ProductOfArrayExceptSelf.productExceptSelf;

public class TD15_ProductOfArrayExceptSelf_Test {

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 2, 3, 4},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int[] nums : numsList) {
            startTime = System.currentTimeMillis();
            result = testMy1(nums);
            endTime = System.currentTimeMillis();
            System.out.println("TD015_ProductOfArrayExceptSelf My 1 during time " + (endTime - startTime));
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
    }

    private static int[] testMy1(int[] nums) {
        return productExceptSelf(nums);
    }
}
