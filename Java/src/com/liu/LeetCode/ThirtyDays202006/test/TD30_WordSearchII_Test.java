package com.liu.LeetCode.ThirtyDays202006.test;

import java.util.List;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD30_WordSearchII.findWords;

/**
 * Created by Liu on 2020/6/30.
 */
public class TD30_WordSearchII_Test {
    public static void main(String[] args) {
        char[][] board;
        String[] words;
        List<String> result;
        long startTime;
        long endTime;

        board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        words = new String[]{"oath", "pea", "eat", "rain"};
        startTime = System.currentTimeMillis();
        result = testMy1(board, words);
        endTime = System.currentTimeMillis();
        System.out.println("TD30_WordSearchII My 1 result size " + result.size() + " during time " + (endTime - startTime));
        for (String string : result) {
            System.out.print(string + " ");
        }
        System.out.println();
    }

    private static List<String> testMy1(char[][] board, String[] words) {
        return findWords(board, words);
    }

}
