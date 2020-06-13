package com.liu.LeetCode.ThirtyDays202005.test;


import static com.liu.LeetCode.ThirtyDays202005.exercise.TD08_CheckIfItIsAStraightLine.checkStraightLine;

/**
 * Created by Liu on 2020/5/8.
 */
public class TD08_CheckIfItIsAStraightLine_Test {

    public static void main(String[] args) {
        int[][] coordinates;
        boolean result;
        long startTime;
        long endTime;

        coordinates = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 6},
                {6, 7}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(coordinates);
        endTime = System.currentTimeMillis();
        System.out.println("TD08_CheckIfItIsAStraightLine My 1 result " + result + " during time " + (endTime - startTime));

        coordinates = new int[][]{
                {1, 1},
                {2, 2},
                {3, 4},
                {4, 5},
                {5, 6},
                {7, 7}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(coordinates);
        endTime = System.currentTimeMillis();
        System.out.println("TD08_CheckIfItIsAStraightLine My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testMy1(int[][] coordinates) {
        return checkStraightLine(coordinates);
    }

}
