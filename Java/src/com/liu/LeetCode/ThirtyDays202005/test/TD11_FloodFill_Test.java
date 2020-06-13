package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD11_FloodFill.floodFill;

/**
 * Created by Liu on 2020/5/11.
 */
public class TD11_FloodFill_Test {

    public static void main(String[] args) {
        int[][] image;
        int sr;
        int sc;
        int newColor;
        int[][] result;
        long startTime;
        long endTime;

        image = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        sr = 1;
        sc = 1;
        newColor = 2;
        startTime = System.currentTimeMillis();
        result = testMy1(image, sr, sc, newColor);
        endTime = System.currentTimeMillis();
        System.out.println("TD11_FloodFill My 1 during time " + (endTime - startTime));
        for (int[] line : result) {
            for (int i : line) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();

        image = new int[][]{{0, 0, 0}, {0, 1, 1}};
        sr = 1;
        sc = 1;
        newColor = 1;
        startTime = System.currentTimeMillis();
        result = testMy1(image, sr, sc, newColor);
        endTime = System.currentTimeMillis();
        System.out.println("TD11_FloodFill My 1 during time " + (endTime - startTime));
        for (int[] line : result) {
            for (int i : line) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] testMy1(int[][] image, int sr, int sc, int newColor) {
        return floodFill(image, sr, sc, newColor);
    }
}
