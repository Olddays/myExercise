package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC289_GameOfLife.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC289_GameOfLifeTest {

    public static void main(String[] args) {
        int[][] board = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1},
        };
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testAnswer1(board);
        endTime = System.currentTimeMillis();
        System.out.println("GameOfLife Answer 1 during time " + (endTime - startTime));
    }

    private static void testAnswer1(int[][] board) {
        getGameOfLifeAnswer1(board);
    }
}
