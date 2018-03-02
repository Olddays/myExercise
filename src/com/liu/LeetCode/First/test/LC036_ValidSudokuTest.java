package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC036_ValidSudoku.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC036_ValidSudokuTest {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        boolean result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testAnswer1(board);
        endTime = System.currentTimeMillis();
        System.out.println("ValidSudoku Answer 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer2(board);
        endTime = System.currentTimeMillis();
        System.out.println("ValidSudoku Answer 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer3(board);
        endTime = System.currentTimeMillis();
        System.out.println("ValidSudoku Answer 3 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer4(board);
        endTime = System.currentTimeMillis();
        System.out.println("ValidSudoku Answer 4 result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testAnswer1(char[][] board) {
        return getValidSudokuAnswer1(board);
    }

    private static boolean testAnswer2(char[][] board) {
        return getValidSudokuAnswe2(board);
    }

    private static boolean testAnswer3(char[][] board) {
        return getValidSudokuAnswer3(board);
    }

    private static boolean testAnswer4(char[][] board) {
        return getValidSudokuAnswe4(board);
    }
}
