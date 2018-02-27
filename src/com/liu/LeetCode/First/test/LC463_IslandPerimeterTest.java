package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC463_IslandPerimeter.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC463_IslandPerimeterTest {

    public static void main(String[] args) {
        int[][][] grids = {
                {{1}, {0}},
                {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}
        };
        long startTime;
        int result;
        long endTime;

        for (int[][] grid : grids) {
            startTime = System.currentTimeMillis();
            result = testMy1(grid);
            endTime = System.currentTimeMillis();
            System.out.println("IslandPerimeter My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(grid);
            endTime = System.currentTimeMillis();
            System.out.println("IslandPerimeter My 2 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int[][] grid) {
        return getIslandPerimeterMy1(grid);
    }

    private static int testMy2(int[][] grid) {
        return getIslandPerimeterMy2(grid);
    }
}
