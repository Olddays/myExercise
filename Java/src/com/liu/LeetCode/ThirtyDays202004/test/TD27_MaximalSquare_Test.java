package com.liu.LeetCode.ThirtyDays202004.test;

import static com.liu.LeetCode.ThirtyDays202004.exercise.TD27_MaximalSquare.maximalSquare;

/**
 * Created by Liu on 2020/4/27.
 */
public class TD27_MaximalSquare_Test {

    public static void main(String[] args) {
        char[][] matrix;
        int result;
        long startTime;
        long endTime;


        matrix = new char[][]{
                {'0', '1', '1', '0', '0', '1', '0', '1', '0', '1'},
                {'0', '0', '1', '0', '1', '0', '1', '0', '1', '0'},
                {'1', '0', '0', '0', '0', '1', '0', '1', '1', '0'},
                {'0', '1', '1', '1', '1', '1', '1', '0', '1', '0'},
                {'0', '0', '1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0', '1', '1', '1', '1', '0'},
                {'0', '0', '0', '1', '1', '0', '0', '0', '1', '0'},
                {'1', '1', '0', '1', '1', '0', '0', '1', '1', '1'},
                {'0', '1', '0', '1', '1', '0', '1', '0', '1', '1'}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(matrix);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));


        matrix = new char[][]{
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(matrix);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));


        matrix = new char[][]{
                {'0', '0', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(matrix);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));


        matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(matrix);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));


        matrix = new char[][]{
                {'1', '1', '1', '0', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(matrix);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));


        matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(matrix);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));


        matrix = new char[][]{
                {'0', '1'}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(matrix);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));


        matrix = new char[][]{
                {'1'}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(matrix);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));

    }

    private static int testMy1(char[][] matrix) {
        return maximalSquare(matrix);
    }
}
