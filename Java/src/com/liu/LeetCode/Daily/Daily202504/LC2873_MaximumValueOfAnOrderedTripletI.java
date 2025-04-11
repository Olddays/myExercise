package com.liu.LeetCode.Daily.Daily202504;

public class LC2873_MaximumValueOfAnOrderedTripletI {
    // 减数、被减数、乘数 大小大 两大一小
    // 核心就是将一个数组分成i-1、i、i+1三段
    // 那么核心就是找到i的位置
    // 那么就找左中右三个标记来计算
    // Beats 100.00%
    private static long maximumTripletValueMy1(int[] nums) {
        int length = nums.length;
        int leftNum = nums[0];
        int rightNum = 0;
        int rightIndex = 0;
        long maxResult = 0;
        for (int centerIndex = 1; centerIndex < length - 1; centerIndex++) {
            int centerNum = nums[centerIndex];
            if (centerIndex >= rightIndex) { // 指针移动到right的右侧了
                rightNum = nums[centerIndex + 1];
                rightIndex = centerIndex + 1;
                for (int right = centerIndex + 2; right < length; right++) {
                    if (nums[right] > rightNum) {
                        rightIndex = right;
                        rightNum = nums[right];
                    }
                }
            }
            long cacheResult = (long) (leftNum - centerNum) * rightNum;
            maxResult = Math.max(maxResult, cacheResult);
            if (centerNum > leftNum) {
                leftNum = centerNum;
            }
        }
        return maxResult;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {6, 11, 12, 12, 7, 9, 2, 11, 12, 4, 19, 14, 16, 8, 16},
                {1000000, 1, 1000000},
                {12, 6, 1, 2, 7},
                {1, 10, 3, 4, 19},
                {1, 2, 3},
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maximumTripletValueMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maximumTripletValue My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
