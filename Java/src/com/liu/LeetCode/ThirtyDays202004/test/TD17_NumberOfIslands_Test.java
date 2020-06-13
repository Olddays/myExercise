package com.liu.LeetCode.ThirtyDays202004.test;


import static com.liu.LeetCode.ThirtyDays202004.exercise.TD17_NumberOfIslands.numIslands;

public class TD17_NumberOfIslands_Test {

    public static void main(String[] args) {
        char[][] grid;
        int result;
        long startTime;
        long endTime;

        grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        startTime = System.currentTimeMillis();
        result = testMy1(grid);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_NumberOfIslands My 1 result: " + result + ", during time " + (endTime - startTime));

        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        startTime = System.currentTimeMillis();
        result = testMy1(grid);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_NumberOfIslands My 1 result: " + result + ", during time " + (endTime - startTime));

    }

    private static int testMy1(char[][] grid) {
        return numIslands(grid);
    }
}
