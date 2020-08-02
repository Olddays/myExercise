package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD17_SurroundedRegions.solveMy1;
import static com.liu.LeetCode.ThirtyDays202006.exercise.TD17_SurroundedRegions.solveAnswer1;

/**
 * Created by Liu on 2020/6/17.
 */
public class TD17_SurroundedRegions_Test {
    public static void main(String[] args) {
        char[][] board;
        long startTime;
        long endTime;


        board = new char[][]{
                {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'X', 'X', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'O', 'O'},
                {'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O'}
        };
        startTime = System.currentTimeMillis();
        testMy1(board);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_SurroundedRegions My 1, during time " + (endTime - startTime));
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();

        board = new char[][]{
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
        };
        startTime = System.currentTimeMillis();
        testMy1(board);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_SurroundedRegions My 1, during time " + (endTime - startTime));
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();

        board = new char[][]{
                {'O', 'O', 'O'},
                {'O', 'X', 'O'},
                {'O', 'O', 'O'},
        };
        startTime = System.currentTimeMillis();
        testMy1(board);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_SurroundedRegions My 1, during time " + (endTime - startTime));
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();

        board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        startTime = System.currentTimeMillis();
        testMy1(board);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_SurroundedRegions My 1, during time " + (endTime - startTime));
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();


        board = new char[][]{
                {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'X', 'X', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'O', 'O'},
                {'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O'}
        };
        startTime = System.currentTimeMillis();
        testAnswer1(board);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_SurroundedRegions Answer 1, during time " + (endTime - startTime));
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();

        board = new char[][]{
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
        };
        startTime = System.currentTimeMillis();
        testAnswer1(board);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_SurroundedRegions Answer 1, during time " + (endTime - startTime));
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();

        board = new char[][]{
                {'O', 'O', 'O'},
                {'O', 'X', 'O'},
                {'O', 'O', 'O'},
        };
        startTime = System.currentTimeMillis();
        testAnswer1(board);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_SurroundedRegions Answer 1, during time " + (endTime - startTime));
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();

        board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        startTime = System.currentTimeMillis();
        testAnswer1(board);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_SurroundedRegions Answer 1, during time " + (endTime - startTime));
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void testMy1(char[][] board) {
        solveMy1(board);
    }

    private static void testAnswer1(char[][] board) {
        solveAnswer1(board);
    }

}
