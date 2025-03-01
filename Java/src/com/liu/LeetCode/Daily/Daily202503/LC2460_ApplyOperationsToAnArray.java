package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;

public class LC2460_ApplyOperationsToAnArray {

    // Beats 96.37%
    private static int[] applyOperationsMy1(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int zeroIndex = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                if (zeroIndex != -1) {
                    nums[zeroIndex] = nums[i];
                    zeroIndex++;
                    nums[i] = 0;
                }
            } else if (zeroIndex == -1) {
                zeroIndex = i;
            }
        }
        return nums;
    }

    // Beats 96.37%
    private static int[] applyOperationsMy2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int index = 0;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                result[index] = nums[i];
                index++;
            }
        }
        if (nums[length - 1] != 0) {
            result[index] = nums[length - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 2, 2, 1, 1, 0},
                {0, 1},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = applyOperationsMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("applyOperations My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
        numsList = new int[][]{
                {1, 2, 2, 1, 1, 0},
                {0, 1},
        };
        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = applyOperationsMy2(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("applyOperations My2 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
