package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC200_NumberOfIslands.numIslands;

public class LC200_NumberOfIslandsTest {

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
