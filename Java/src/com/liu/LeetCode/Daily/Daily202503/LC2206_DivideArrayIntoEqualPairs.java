package com.liu.LeetCode.Daily.Daily202503;

public class LC2206_DivideArrayIntoEqualPairs {

    // Beats 100.00%
    private static boolean divideArrayMy1(int[] nums) {
        int[] cache = new int[501]; // 题目说nums[i] <= 500
        for (int num : nums) {
            cache[num]++;
        }
        for (int i = 1; i <= 500; i++) {
            if (cache[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {3, 2, 3, 2, 2, 2},
                {1, 2, 3, 4},
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = divideArrayMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("divideArray My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
