package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC079_WordSearch.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC079_WordSearchTest {

    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
//                {'a', 'a', 'a', 'a'},
//                {'a', 'a', 'a', 'a'},
//                {'a', 'a', 'a', 'a'},
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'E', 'S'},
//                {'A', 'D', 'E', 'E'},
//                {'a', 'b'},
//                {'c', 'd'},
//                {'a', 'a'},
        };
        String target = "ABCCED";
//        String target = "SEE";
//        String target = "ABCB";
//        String target = "aaaaaaaaaaab";
//        String target = "ABCESEEEFS";
//        String target = "abcd";
//        String target = "aaa";
        boolean result = false;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        //由于疏忽出现了问题
//        result = testMy1(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("WordSearch My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("WordSearch My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy3(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("WordSearch My 3 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy4(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("WordSearch My 4 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy5(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("WordSearch My 5 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("WordSearch Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testMy1(char[][] board, String word) {
        return getWordSearchMy1(board, word);
    }

    private static boolean testMy2(char[][] board, String word) {
        return getWordSearchMy2(board, word);
    }

    private static boolean testMy3(char[][] board, String word) {
        return getWordSearchMy3(board, word);
    }

    private static boolean testMy4(char[][] board, String word) {
        return getWordSearchMy4(board, word);
    }

    private static boolean testMy5(char[][] board, String word) {
        return getWordSearchMy5(board, word);
    }

    private static boolean testAnswer1(char[][] board, String word) {
        return getWordSearchAnswer1(board, word);
    }
}
