package com.liu.LeetCode.SeasonMatch20200418.test;

import static com.liu.LeetCode.SeasonMatch20200418.exercise.SM03_BeginMomentOfATheatre.getTriggerTimeMy1;
import static com.liu.LeetCode.SeasonMatch20200418.exercise.SM03_BeginMomentOfATheatre.getTriggerTimeMy2;
import static com.liu.LeetCode.SeasonMatch20200418.exercise.SM03_BeginMomentOfATheatre.getTriggerTimeMy3;

public class SM03_BeginMomentOfATheatre_Test {

    public static void main(String[] args) {
        int[][] increas;
        int[][] requirements;

        int[] result;
        long startTime;
        long endTime;


        increas = new int[][]{{2, 8, 4}, {2, 5, 0}, {10, 9, 8}};
        requirements = new int[][]{{2, 11, 3}, {15, 10, 7}, {9, 17, 12}, {8, 1, 14}};

        startTime = System.currentTimeMillis();
        result = testMy1(increas, requirements);
        endTime = System.currentTimeMillis();
        System.out.println("SM03_BeginMomentOfATheatre My 1 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();


        startTime = System.currentTimeMillis();
        result = testMy2(increas, requirements);
        endTime = System.currentTimeMillis();
        System.out.println("SM03_BeginMomentOfATheatre My 2 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();


        startTime = System.currentTimeMillis();
        result = testMy3(increas, requirements);
        endTime = System.currentTimeMillis();
        System.out.println("SM03_BeginMomentOfATheatre My 3 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();


        increas = new int[][]{{0, 4, 5}, {4, 8, 8}, {8, 6, 1}, {10, 10, 0}};
        requirements = new int[][]{{12, 11, 16}, {20, 2, 6}, {9, 2, 6}, {10, 18, 3}, {8, 14, 9}};

        startTime = System.currentTimeMillis();
        result = testMy1(increas, requirements);
        endTime = System.currentTimeMillis();
        System.out.println("SM03_BeginMomentOfATheatre My 1 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy2(increas, requirements);
        endTime = System.currentTimeMillis();
        System.out.println("SM03_BeginMomentOfATheatre My 2 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy3(increas, requirements);
        endTime = System.currentTimeMillis();
        System.out.println("SM03_BeginMomentOfATheatre My 3 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();


        increas = new int[][]{{1, 1, 1}};
        requirements = new int[][]{{0, 0, 0}};

        startTime = System.currentTimeMillis();
        result = testMy1(increas, requirements);
        endTime = System.currentTimeMillis();
        System.out.println("SM03_BeginMomentOfATheatre My 1 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy2(increas, requirements);
        endTime = System.currentTimeMillis();
        System.out.println("SM03_BeginMomentOfATheatre My 2 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy3(increas, requirements);
        endTime = System.currentTimeMillis();
        System.out.println("SM03_BeginMomentOfATheatre My 3 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    private static int[] testMy1(int[][] increas, int[][] requirements) {
        return getTriggerTimeMy1(increas, requirements);
    }

    private static int[] testMy2(int[][] increas, int[][] requirements) {
        return getTriggerTimeMy2(increas, requirements);
    }

    private static int[] testMy3(int[][] increas, int[][] requirements) {
        return getTriggerTimeMy3(increas, requirements);
    }

}
