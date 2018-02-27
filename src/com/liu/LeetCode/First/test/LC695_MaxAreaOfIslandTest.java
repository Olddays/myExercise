package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC695_MaxAreaOfIsland.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC695_MaxAreaOfIslandTest {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(grid);
        endTime = System.currentTimeMillis();
        System.out.println("MaxAreaOfIsland My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(grid);
        endTime = System.currentTimeMillis();
        System.out.println("MaxAreaOfIsland Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[][] grid) {
        return getMaxAreaOfIslandMy1(grid);
    }

    private static int testAnswer1(int[][] grid) {
        return getMaxAreaOfIslandAnswer1(grid);
    }
}
