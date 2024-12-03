package com.liu.LeetCode.CodeCaprice.Array;

import java.util.Arrays;

public class LC977_SquaresOfASortedArray {
    // 核心就是关注负数

    // 先平方，再排序，时间复杂度O(nlogn)
    private static int[] sortedSquaresMy1(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }

    // 双指针
    // 为什么会想到双指针，因为数组有序，所以绝对值最大的元素一定在两侧
    // 所以可以用两个指针，从原始数组的两端逐渐向中间靠拢的方式来进行实现
    // 一次动一个
    // left可以等于right，因为数组的长度可能为1
    private static int[] sortedSquaresMy2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int left = 0;
        int right = length - 1;
        int resultPoint = length - 1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            result[resultPoint] = Math.max(rightSquare, leftSquare);
            resultPoint--;
            if (rightSquare > leftSquare) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {-7, -3, 2, 3, 11},
                {-4, -1, 0, 3, 10},
                {0, 0, 1, 2, 2, 2, 3, 4},
                {2},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = sortedSquaresMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("sortedSquares My1 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = sortedSquaresMy2(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("sortedSquares My2 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
