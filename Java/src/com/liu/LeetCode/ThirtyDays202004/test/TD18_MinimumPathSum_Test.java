package com.liu.LeetCode.ThirtyDays202004.test;


import static com.liu.LeetCode.ThirtyDays202004.exercise.TD18_MinimumPathSum.minPathSumMy1;
import static com.liu.LeetCode.ThirtyDays202004.exercise.TD18_MinimumPathSum.minPathSumMy2;

public class TD18_MinimumPathSum_Test {

    public static void main(String[] args) {
        int[][] grid;

        int result;
        long startTime;
        long endTime;

        grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(grid);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_NumberOfIslands My 1 result: " + result + ", during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(grid);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_NumberOfIslands My 2 result: " + result + ", during time " + (endTime - startTime));

        grid = new int[][]{
                {1, 2, 5},
                {3, 2, 1}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(grid);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_NumberOfIslands My 1 result: " + result + ", during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(grid);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_NumberOfIslands My 2 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(int[][] grid) {
        return minPathSumMy1(grid);
    }

    private static int testMy2(int[][] grid) {
        return minPathSumMy2(grid);
    }
}
