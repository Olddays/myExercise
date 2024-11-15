package com.liu.LeetCode.FifteenPatterns.DynamicProgrammingPatterns.KadanesAlgorithm;

public class LC152_MaximumProductSubarray {
    private static int maxProductMy1(int[] nums) {

    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {2, 3, -2, 4},
                {-2, 0, -1},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxProductMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProduct My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxProductMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProduct Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
