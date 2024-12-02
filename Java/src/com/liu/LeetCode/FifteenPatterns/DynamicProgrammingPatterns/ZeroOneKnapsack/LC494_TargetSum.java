package com.liu.LeetCode.FifteenPatterns.DynamicProgrammingPatterns.ZeroOneKnapsack;

public class LC494_TargetSum {

    private static int findTargetSumWaysMy1(int[] nums, int target) {
        int result = 0;
        int length = nums.length;
        boolean[][] dp = new boolean[length][length / 2 + 1];
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 1, 1, 1, 1},
                {1},
        };
        int[] targetSet = new int[]{
                3,
                1,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = findTargetSumWaysMy1(numsList[i], targetSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findTargetSumWays My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

    }
}
