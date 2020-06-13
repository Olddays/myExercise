package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD21_CountSquareSubmatricesWithAllOnes.countSquares;

/**
 * Created by Liu on 2020/5/22.
 */
public class TD21_CountSquareSubmatricesWithAllOnes_Test {
    public static void main(String[] args) {
        int[][] matrix;
        int result;
        long startTime;
        long endTime;

        matrix = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(matrix);
        endTime = System.currentTimeMillis();
        System.out.println("TD21_CountSquareSubmatricesWithAllOnes My 1 result: " + result + ", during time " + (endTime - startTime));

        matrix = new int[][]{
                {0, 0, 0},
                {0, 1, 1}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(matrix);
        endTime = System.currentTimeMillis();
        System.out.println("TD21_CountSquareSubmatricesWithAllOnes My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(int[][] matrix) {
        return countSquares(matrix);
    }
}
