package com.liu.LeetCode.Second.TwoPointers;

public class LC011_ContainerWithMostWater {

    private static int maxAreaMy1(int[] height) {
        int result = 0;
        int length = height.length;
        if (length <= 1) {
            return result;
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            result = Math.max(result, min * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 8, 6, 2, 5, 4, 8, 3, 7},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxAreaMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("ContainerWithMostWater My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
