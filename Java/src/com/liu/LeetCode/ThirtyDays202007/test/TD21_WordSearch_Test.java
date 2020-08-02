package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD21_WordSearch.exist;

/**
 * Created by Liu on 2020/7/21.
 */
public class TD21_WordSearch_Test {
    public static void main(String[] args) {
        char[][] board;
        String word;
        boolean result;
        long startTime;
        long endTime;


        board = new char[][]{
                {'a'}
        };
        word = "a";
        startTime = System.currentTimeMillis();
        result = testMy1(board, word);
        endTime = System.currentTimeMillis();
        System.out.println("TD21_WordSearch My 1 result: " + result + ", during time " + (endTime - startTime));

        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        word = "SEE";
        startTime = System.currentTimeMillis();
        result = testMy1(board, word);
        endTime = System.currentTimeMillis();
        System.out.println("TD21_WordSearch My 1 result: " + result + ", during time " + (endTime - startTime));

        word = "ABCCED";
        startTime = System.currentTimeMillis();
        result = testMy1(board, word);
        endTime = System.currentTimeMillis();
        System.out.println("TD21_WordSearch My 1 result: " + result + ", during time " + (endTime - startTime));

        word = "ABCB";
        startTime = System.currentTimeMillis();
        result = testMy1(board, word);
        endTime = System.currentTimeMillis();
        System.out.println("TD21_WordSearch My 1 result: " + result + ", during time " + (endTime - startTime));

    }

    private static boolean testMy1(char[][] board, String word) {
        return exist(board, word);
    }

}
