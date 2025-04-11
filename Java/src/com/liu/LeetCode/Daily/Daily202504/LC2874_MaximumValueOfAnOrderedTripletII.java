package com.liu.LeetCode.Daily.Daily202504;

public class LC2874_MaximumValueOfAnOrderedTripletII {

    // Beats 5.91%
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

    // Beats 97.85%
    private static long maximumTripletValueMy2(int[] nums) {
        int n = nums.length, maxRight = 0, maxLeft = nums[0];
        long res = 0;
        int[] rightMax = new int[n]; // 先算出来每一个位置的右侧最大值
        for (int i = n - 1; i >= 0; i--) {
            rightMax[i] = maxRight;
            maxRight = Math.max(maxRight, nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, (long) rightMax[i] * (maxLeft - nums[i]));
            maxLeft = Math.max(maxLeft, nums[i]);
        }
        return res;
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

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maximumTripletValueMy2(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maximumTripletValue My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
