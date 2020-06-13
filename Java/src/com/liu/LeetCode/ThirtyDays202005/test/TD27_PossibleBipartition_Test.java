package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD27_PossibleBipartition.possibleBipartition;

/**
 * Created by Liu on 2020/5/28.
 */
public class TD27_PossibleBipartition_Test {
    public static void main(String[] args) {
        int N;
        int[][] dislikes;
        boolean result;
        long startTime;
        long endTime;


        N = 10;
        dislikes = new int[][]{
                {4, 7}, {4, 8}, {5, 6}, {1, 6}, {3, 7}, {2, 5}, {5, 8}, {1, 2},
                {4, 9}, {6, 10}, {8, 10}, {3, 6}, {2, 10}, {9, 10}, {3, 9},
                {2, 3}, {1, 9}, {4, 6}, {5, 7}, {3, 8}, {1, 8}, {1, 7}, {2, 4}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(N, dislikes);
        endTime = System.currentTimeMillis();
        System.out.println("TD27_PossibleBipartition My 1 result: " + result + ", during time " + (endTime - startTime));

        N = 5;
        dislikes = new int[][]{
                {1, 2},
                {3, 4},
                {4, 5},
                {3, 5}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(N, dislikes);
        endTime = System.currentTimeMillis();
        System.out.println("TD27_PossibleBipartition My 1 result: " + result + ", during time " + (endTime - startTime));

        N = 4;
        dislikes = new int[][]{
                {1, 2},
                {1, 3},
                {2, 4}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(N, dislikes);
        endTime = System.currentTimeMillis();
        System.out.println("TD27_PossibleBipartition My 1 result: " + result + ", during time " + (endTime - startTime));

        N = 3;
        dislikes = new int[][]{
                {1, 2},
                {1, 3},
                {2, 3}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(N, dislikes);
        endTime = System.currentTimeMillis();
        System.out.println("TD27_PossibleBipartition My 1 result: " + result + ", during time " + (endTime - startTime));

        N = 5;
        dislikes = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {1, 5}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(N, dislikes);
        endTime = System.currentTimeMillis();
        System.out.println("TD27_PossibleBipartition My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static boolean testMy1(int N, int[][] dislikes) {
        return possibleBipartition(N, dislikes);
    }
}
