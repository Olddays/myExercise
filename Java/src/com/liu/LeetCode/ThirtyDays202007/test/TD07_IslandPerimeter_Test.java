package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD07_IslandPerimeter.islandPerimeter;

/**
 * Created by Liu on 2020/7/7.
 */
public class TD07_IslandPerimeter_Test {
    public static void main(String[] args) {
        int[][] grid;
        int result;
        long startTime;
        long endTime;


        grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(grid);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_IslandPerimeter My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(int[][] grid) {
        return islandPerimeter(grid);
    }
}
