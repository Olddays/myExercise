package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC037_SudokuSolver.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC037_SudokuSolverTest {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testAnswer1(board);
        endTime = System.currentTimeMillis();
        System.out.println("SudokuSolver Answer 1 result during time " + (endTime - startTime));
    }

    private static void testAnswer1(char[][] board) {
        getSudokuSolverAnswer1(board);
    }
}
